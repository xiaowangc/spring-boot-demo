package com.chige.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.io.IOUtils;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;


/**
 * @author wangyc
 * @date 2022/5/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {
    private static final Logger log = LoggerFactory.getLogger(ESTest.class);
    @Autowired
    private RestHighLevelClient restClient;
    @Value("classpath:/mapping/customerInfoIndex.json")
    private Resource customerInfoIndex;
    private static final String index = "customer_dev_index";

    /**
     * 创建索引
     */
    @Test
    public void testCreateIndex() throws IOException {
        boolean exists = restClient.indices().exists(new GetIndexRequest(index), RequestOptions.DEFAULT);
        if (exists) {
            this.testDelIndex();
        }
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        createIndexRequest.mapping(IOUtils.toString(customerInfoIndex.getInputStream()), XContentType.JSON);
        try {
            CreateIndexResponse createIndexResponse = restClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            log.info("创建索引返回信息：{}", createIndexResponse.isAcknowledged());
            Assertions.assertTrue(createIndexResponse.isAcknowledged(), "创建索引失败");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除索引
     */
    @Test
    public void testDelIndex() {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
        try {
            AcknowledgedResponse deleteFlag = restClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            Assertions.assertTrue(deleteFlag.isAcknowledged(), "删除索引失败");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否存在索引
     */
    @Test
    public void testExistsIndex() {
        GetIndexRequest indexRequest = new GetIndexRequest(index);
        try {
            boolean exists = restClient.indices().exists(indexRequest, RequestOptions.DEFAULT);
            Assertions.assertTrue(exists, "不存在索引");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 插入数据
     */
    @Test
    public void testInsert() {

        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.id("1_1_1_5");
        String data = "";
        indexRequest.source(data, XContentType.JSON);
        try {
            IndexResponse response = restClient.index(indexRequest, RequestOptions.DEFAULT);
            log.info("插入的数据id={}", response.getId());
            Assertions.assertEquals(response.status().getStatus(), 201, "状态码不为成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文档数据
     */
    @Test
    public void testGetDoc() {
        GetRequest getRequest = new GetRequest(index);
        getRequest.id("1_1_1_5");
        try {
            GetResponse documentFields = restClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String, Object> source = documentFields.getSource();
            Assertions.assertNotNull(source);
        } catch (IOException e) {

        }
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdate() {
        UpdateRequest updateRequest = new UpdateRequest();
        PersonInfo personInfo = new PersonInfo("王1", 19, "内容1", "地址2", new Date());
        updateRequest.index(index);
        updateRequest.id("1");
        // 新的文档数据
        updateRequest.doc(personInfo.toString(), XContentType.JSON);
        try {
            UpdateResponse updateResponse = restClient.update(updateRequest, RequestOptions.DEFAULT);
            Assertions.assertEquals(updateResponse.getResult().getOp(), DocWriteResponse.Result.UPDATED, "状态码不为成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量添加
     */
    @Test
    public void testBulk() {
        // 批量请求对象
        BulkRequest bulkRequest = new BulkRequest(index);

        int requestId = 1;
        for (int i = 0; i < 10; i++) {
            IndexRequest indexRequest = new IndexRequest();
            requestId++;
            PersonInfo personInfo = new PersonInfo("王1", 1, "内容1", "地址2", new Date());
            bulkRequest.add(indexRequest.id(requestId + "")
                    .source(personInfo.toString(), XContentType.JSON));
        }

        try {
            BulkResponse bulkResponse = restClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            log.info("批量请求结果:{}", bulkResponse);
            Assertions.assertNotNull(bulkResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除数据
     */
    @Test
    public void testDel() {
        DeleteRequest deleteRequest = new DeleteRequest(index);
        deleteRequest.id("1_1_1_5");
        try {
            DeleteResponse delete = restClient.delete(deleteRequest, RequestOptions.DEFAULT);
            Assertions.assertEquals(delete.status().getStatus(), 200, "删除数据失败");
        } catch (IOException e) {

        }
    }

    /**
     * 搜索查询的方式
     */
    private void query() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 查询所有
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();

        // 指定一个属性查询
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("age", "8");

        // 指定多个属性查询
        String[] keywords = new String[]{"true_name", "nick_name", "remark_name", "customer_code", "mobile"};
        MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery("小王", keywords);

        // 分页、排序、指定返回字段
        searchSourceBuilder
                .from(0)
                .size(10)
                .sort("age", SortOrder.ASC)
                .fetchSource("age", "name");


        /**
         * NOTE1: 通过使用term查询得知ES中默认使用分词器为标准分词器(StandardAnalyzer),标准分词器对于英文单词分词,对于中文单字分词。
         *
         * NOTE2: 通过使用term查询得知,在ES的Mapping Type 中 keyword , date ,integer, long , double , boolean or ip 这些类型不分词，只有text类型分词。
         */
        // 按关键词查询 term
        QueryBuilders.termQuery("true_name", "王");

        //短语搜索：搜索指定字段中同时包含"深圳"和"南山"
        QueryBuilders.matchPhraseQuery("address", "深圳 南山");

        //组合搜索 bool + must 与组合，同时满足， 查询字段address中不仅包含A而且包含B
        List<QueryBuilder> must = QueryBuilders.boolQuery().must();
        must.add(QueryBuilders.matchQuery("address", "深圳"));
        must.add(QueryBuilders.matchQuery("address", "南山"));

        //组合搜索 bool + should 或组合 查询字段中包含A或者包含B的字段
        List<QueryBuilder> should = QueryBuilders.boolQuery().should();
        should.add(QueryBuilders.matchQuery("address", "深圳"));
        should.add(QueryBuilders.matchQuery("address", "南山"));

        //组合搜索 bool + must_not 非组合,同时不满足
            List<QueryBuilder> queryBuilders = QueryBuilders.boolQuery().mustNot();
            queryBuilders.add(QueryBuilders.matchQuery("address", "深圳"));
            queryBuilders.add(QueryBuilders.matchQuery("address", "南山"));

        //组合搜索 bool + must_not + must  筛选以及排除
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<QueryBuilder> must1 = boolQueryBuilder.must();
        List<QueryBuilder> mustNot = boolQueryBuilder.mustNot();
        must1.add(QueryBuilders.matchQuery("name", "aa"));
        must1.add(QueryBuilders.matchQuery("name", "bb"));
        mustNot.add(QueryBuilders.matchQuery("age", "40"));
        mustNot.add(QueryBuilders.matchQuery("age", "50"));

        //过滤搜索 bool + filter  过滤出age在[10,20]之间的文档
        List<QueryBuilder> filter = QueryBuilders.boolQuery().filter();
        filter.add(QueryBuilders.rangeQuery("age").gte(10).lte(20));

        
    }



    /**
     * 1、模糊查询
     * match_all
     */
    @Test
    public void testMatchAll() {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder sourceBuilder = searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        // 设置查询条件
        searchRequest.source(sourceBuilder);
        this.search(searchRequest);
    }

    /**
     * 1、模糊查询
     * match 搜索
     */
    @Test
    public void testMatch() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source().query(QueryBuilders.matchQuery("name", "王"));
        this.search(searchRequest);
    }

    /**
     * 1、模糊查询
     * multi_match多字段查询
     */
    @Test
    public void testMultiMatch() {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source().query(QueryBuilders.multiMatchQuery("6", "name", "age"));
        this.search(searchRequest);
    }

    /**
     * 2、精确查询: term
     */
    @Test
    public void testTerm() {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source().query(QueryBuilders.termQuery("name", "王1"));
        this.search(searchRequest);

        SearchRequest searchRequest2 = new SearchRequest(index);
        searchRequest2.source().query(QueryBuilders.termQuery("name", "王w"));
        this.search(searchRequest2);
    }

    /**
     * 2、精确查询: range查询
     */
    @Test
    public void testRange() {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source().query(QueryBuilders.rangeQuery("name").gte(10).lte(18));
        this.search(searchRequest);
    }

    /**
     * 2、精确查询: 复合查询 bool
     */
    @Test
    public void testBool() {
        SearchRequest searchRequest = new SearchRequest(index);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must();
        boolQueryBuilder.mustNot();
        boolQueryBuilder.filter();
        this.search(searchRequest);
    }

    /**
     * 排序和分页
     */
    @Test
    public void testSortAndPage() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequest searchRequest = new SearchRequest("ems");
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //构建分页、按指定属性排序
        searchSourceBuilder.from(2).size(2).sort("age", SortOrder.ASC);
        searchRequest.source(searchSourceBuilder);
        this.search(searchRequest);
    }

    /**
     * 查询返回指定字段
     */
    @Test
    public void testFetchSource() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequest searchRequest = new SearchRequest("ems");
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(0)
                .size(2)
                .fetchSource(new String[]{"age", "name", "bir"}, new String[]{"content"});
        searchRequest.source(searchSourceBuilder);
        this.search(searchRequest);
    }

    /**
     * 高亮处理
     */
    @Test
    public void testHighlight() {

    }

    /**
     * 执行搜索对象
     */
    private void search(SearchRequest searchRequest) {
        try {
            SearchResponse searchResponse = restClient.search(searchRequest, RequestOptions.DEFAULT);
            this.handleSearchResp(searchResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 封装处理搜索到的结果
     */
    private void handleSearchResp(SearchResponse searchResponse) {
        long total = searchResponse.getHits().getTotalHits().value;
        log.info("查询到的结果长度为:{}", total);
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        for (SearchHit searchHit : searchHits) {
            log.info("解析对象:{}", searchHit.toString());
        }
    }

    @ToString
    @AllArgsConstructor
    @Data
    public class PersonInfo {
        private String name;
        private Integer age;
        private String content;
        private String address;
        private Date bir;
    }
}

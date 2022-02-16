package com.chige.es.repository;

import com.chige.es.ESApplication;
import com.chige.es.domain.ESAccountDO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class ProductRepositoryTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testProductRep() {
//        this.testInsert();
//        this.testDeleteOne();
//        this.testUpdate();
        this.testQueryById();
        this.testQueryByIds();
    }

    /**
     *  插入一条记录
     */
    private void testInsert() {
        ESAccountDO product = new ESAccountDO();
        product.setAccountNumber(31L);
        product.setBalance(10031L);
        product.setFirstName("王");
        product.setLastName("chige");
        product.setAge(18L);
        product.setGender("F");
        product.setAddress("797 Moffat Street");
        product.setEmployer("Niquent");
        product.setEmail("xiaowangy@qq.com");
        product.setCity("Zarephath");
        product.setState("DE");
    }
    /**
     *  更新一条记录
     */
    private void testUpdate() {

    }
    /**
     *  删除一条记录
     */
    private void testDeleteOne() {

    }
    /**
     *  查询一条记录
     */
    private void testQueryById() {

    }
    /**
     *  查询一批数据
     */
    private void testQueryByIds() {

    }

    /**
     *  构建查询条件
     * @param queryMap
     * @return
     */
    private BoolQueryBuilder getBoolQueryBuilder(Map<String, Object> queryMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        // 模糊匹配
        // 精准匹配

        return boolQueryBuilder;
    }

}

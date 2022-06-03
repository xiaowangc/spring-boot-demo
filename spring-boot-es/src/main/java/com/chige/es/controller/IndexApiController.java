package com.chige.es.controller;

import com.chige.es.entity.request.IndexRequest;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 *   索引的创建、删除、查询操作
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexApiController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     *  创建索引 - 自动创建id
     */
    @PostMapping("/create/auto")
    public String createIndexAuto(@RequestBody IndexRequest request) {
        CreateIndexRequest indexRequest = new CreateIndexRequest(request.getIndexName());
        try {
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);
            boolean acknowledged = createIndexResponse.isAcknowledged();
            log.info(">>> 创建索引 - {}", acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }
    /**
     *  创建索引 - 指定id
     */
    @PutMapping("/create/id")
    public String createIndexWithId(@RequestBody IndexRequest indexRequest) {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexRequest.getIndexName());
        try {
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            boolean acknowledged = createIndexResponse.isAcknowledged();
            log.info(">>> 创建索引 - {}", acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "OK";
    }
    /**
     *  删除指定索引
     */
    @DeleteMapping("/delete/index/{id}")
    public String deleteIndexWithId(@PathVariable("id") Integer id) {
        return "OK";
    }
}

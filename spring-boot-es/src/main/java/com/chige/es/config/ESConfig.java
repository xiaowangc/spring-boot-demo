package com.chige.es.config;

import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyc
 * @date 2022/1/12
 */

@Configuration
public class ESConfig {

    @Bean("esConfig")
    public ElasticsearchClient getESClient() {
        return null;
    }

}

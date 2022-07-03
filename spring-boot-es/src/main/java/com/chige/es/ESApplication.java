package com.chige.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author wangyc
 * @date 2022/1/11
 */
@SpringBootApplication(exclude = {ElasticsearchDataAutoConfiguration.class})
@ConfigurationPropertiesScan(basePackages = {"com.chige.es.config"})
public class ESApplication {
    private static final Logger log = LoggerFactory.getLogger(ESApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ESApplication.class, args);
        log.info("ES application start success...");
    }
}

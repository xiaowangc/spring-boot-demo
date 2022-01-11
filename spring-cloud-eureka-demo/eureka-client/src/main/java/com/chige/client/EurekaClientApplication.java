package com.chige.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangyc
 * @date 2021/8/21
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    private static final Logger log = LoggerFactory.getLogger(EurekaClientApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
        log.info("Eureka client is started successfully.");
    }

}

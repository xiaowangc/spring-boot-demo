package com.chige.server.center;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangyc
 * @date 2021/8/21
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    private static final Logger log = LoggerFactory.getLogger(EurekaServerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class);
        log.info("Eureka serve is started successfully.");
    }
}

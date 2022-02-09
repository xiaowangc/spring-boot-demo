package com.chige.dozer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangyc
 * @date 2022/1/25
 */
@SpringBootApplication
public class DozerDemoApp {

    private static final Logger log = LoggerFactory.getLogger(DozerDemoApp.class);
    public static void main(String[] args) {
        SpringApplication.run(DozerDemoApp.class, args);
        log.info(">>> Dozer dome started successfully.");
    }
}

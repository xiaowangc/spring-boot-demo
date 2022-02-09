package com.chige.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangyc
 * @date 2022/1/20
 */
@SpringBootApplication
public class DubboDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DubboDemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DubboDemoApplication.class, args);
        log.info(">>> Dubbo demo started successfully...");
    }
}

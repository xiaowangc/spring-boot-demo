package com.chige.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangyc
 * @date 2022/6/3
 */
@SpringBootApplication
public class NewProjectApplication {
    private static final Logger log = LoggerFactory.getLogger(NewProjectApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(NewProjectApplication.class, args);
        log.info(">>> Application starts successfully.");
    }
}

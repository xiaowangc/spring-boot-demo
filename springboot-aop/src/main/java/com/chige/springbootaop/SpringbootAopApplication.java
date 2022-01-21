package com.chige.springbootaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAopApplication {

    private static Logger log = LoggerFactory.getLogger(SpringbootAopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopApplication.class, args);
        log.info("启动成功...");
    }

}

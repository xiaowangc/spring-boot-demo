package com.chige.configLoad;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@SpringBootApplication
public class ConfigLoadApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigLoadApp.class, args);
        LoggerFactory.getLogger(ConfigLoadApp.class).info("启动成功...");
    }
}

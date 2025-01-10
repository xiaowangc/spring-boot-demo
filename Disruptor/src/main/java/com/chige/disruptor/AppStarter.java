package com.chige.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author wangyc
 * @Description 启动类
 * @Date 2024/9/6 11:51
 */
@SpringBootApplication
public class AppStarter {

    private static final Logger log = LoggerFactory.getLogger(AppStarter.class);
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
        log.info("启动成功...");

    }
}

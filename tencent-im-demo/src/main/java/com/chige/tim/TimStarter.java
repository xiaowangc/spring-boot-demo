package com.chige.tim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2024/8/3 15:36
 */
@Slf4j
@SpringBootApplication
public class TimStarter {

    public static void main(String[] args) {
        SpringApplication.run(TimStarter.class, args);
        log.info("启动成功");

    }
}

package com.chige;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangyc
 * @date 2021/11/19
 */
@EnableFeignClients(basePackages = "com.chige.openfeign.intergetion")
@SpringBootApplication
public class OpenFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApp.class, args);
    }
}

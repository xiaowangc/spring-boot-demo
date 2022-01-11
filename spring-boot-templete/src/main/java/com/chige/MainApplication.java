package com.chige;

import com.chige.openfeign.config.FoodConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@SpringBootConfiguration
@EnableConfigurationProperties({FoodConfig.class})
public class MainApplication {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}

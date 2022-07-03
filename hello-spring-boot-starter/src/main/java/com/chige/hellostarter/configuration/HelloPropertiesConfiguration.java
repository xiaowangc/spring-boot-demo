package com.chige.hellostarter.configuration;

import com.chige.hellostarter.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyc
 * @date 2022/7/3
 */
@Slf4j
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({HelloProperties.class})
public class HelloPropertiesConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloServiceImpl getHelloService() {
        HelloServiceImpl helloService = new HelloServiceImpl();
        log.info("初始化helloProperties对象：{}", helloProperties);
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }

}

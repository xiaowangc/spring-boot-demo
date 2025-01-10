package com.chige.sdk.door.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author wangyc
 * @date 2023/10/16
 */
@EnableAutoConfiguration
@ConditionalOnClass(value = StarterService.class)
@EnableConfigurationProperties(value = StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "com.chige.sdk.door", value = "enabled", havingValue = "true")
    StarterService getStarterService() {
        return new StarterService(properties.getUserStr());
    }
}

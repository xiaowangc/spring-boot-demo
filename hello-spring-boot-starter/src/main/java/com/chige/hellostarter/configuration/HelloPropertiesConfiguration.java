package com.chige.hellostarter.configuration;

import cn.hutool.json.JSONUtil;
import com.chige.hellostarter.service.HelloService;
import com.chige.hellostarter.service.impl.HelloServiceImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyc
 * @date 2022/7/3
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties({HelloProperties.class})
public class HelloPropertiesConfiguration {
    private static final Logger log = LoggerFactory.getLogger(HelloPropertiesConfiguration.class);
    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloServiceImpl getHelloService() {
        HelloServiceImpl helloService = new HelloServiceImpl();
        helloService.setHelloProperties(helloProperties);
        log.info("初始化helloProperties对象：{}", ToStringBuilder.reflectionToString(helloService, ToStringStyle.JSON_STYLE));
        log.info("1:{}", JSONUtil.toJsonStr(helloService));
        return helloService;
    }

    @Bean
    @ConditionalOnMissingBean
    public FactoryBeanOne getFactoryBeanOne() {
        log.info("加载factoryBeanOn");
        return new FactoryBeanOne();
    }

}

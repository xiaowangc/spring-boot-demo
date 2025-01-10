package com.chige.expand.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author wangyc
 * @Description 环境配置自定义初始化：在应用上下文初始化时进行一些环境相关的配置，例如设置系统属性、加载外部配置文件等
 * @Date 2025/1/8 18:55
 */
public class EnvironmentInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        environment.setActiveProfiles("development");
        System.out.println("配置文件设置为-development");
    }
}

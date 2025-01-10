package com.chige.expand.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Collections;

/**
 * @Author wangyc
 * @Description 属性配置初始化：在初始化过程中动态地添加 PropertySource，以便后续的 Bean 定义和初始化过程中可以使用这些属性。
 * @Date 2025/1/8 18:57
 */
public class PropertySourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();

        propertySources.addFirst(new MapPropertySource("customerPropertySource", Collections.singletonMap("customerKey", "customerValue")));

        System.out.println("已添加自定义属性源");
    }
}

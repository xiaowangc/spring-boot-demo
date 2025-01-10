package com.chige.expand.initializer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author wangyc
 * @Description 注册自定义的 BeanFactoryPostProcessor 或者 BeanPostProcessor，以便在 Bean 初始化之前或之后进行某些自定义处理
 * @Date 2025/1/8 18:46
 */
public class CustomBeanFactoryPostProcessorInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 添加自定义的 BeanFactoryPostProcessor
            BeanDefinition beanA = beanFactory.getBeanDefinition("beanA");
            System.out.println("添加了自定义BeanFactory后处理器..." + beanA.getBeanClassName());
        });
    }
}

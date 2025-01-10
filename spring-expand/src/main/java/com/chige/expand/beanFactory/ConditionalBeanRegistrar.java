package com.chige.expand.beanFactory;

import com.chige.expand.domain.BeanA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author wangyc
 * @Description 动态注册 Bean：可以根据配置文件或者系统环境变量来决定是否注册某个Bean
 * @Date 2025/1/8 23:08
 */
public class ConditionalBeanRegistrar implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //构建指定Bean的beanDefinition信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BeanA.class);

    }
}

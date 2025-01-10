package com.chige.expand.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author wangyc
 * @Description
 * 1. 修改 Bean 属性：可以动态地改变某些配置属性或者注入额外的依赖。
 * @Date 2025/1/8 23:06
 */
public class PropertyModifierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("修改Bean属性");
        BeanDefinition beanA = beanFactory.getBeanDefinition("BeanA");
        MutablePropertyValues propertyValues = beanA.getPropertyValues();
        propertyValues.addPropertyValue("sex", 1);
    }
}

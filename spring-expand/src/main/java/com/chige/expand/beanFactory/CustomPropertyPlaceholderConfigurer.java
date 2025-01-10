package com.chige.expand.beanFactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @Author wangyc
 * @Description 自定义属性占位符替换： 可以使用 PropertyPlaceholderConfigurer 实现 BeanFactoryPostProcessor 接口，来替换 Bean 定义中的属性占位符
 * @Date 2025/1/8 23:24
 */
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) {
        super.processProperties(beanFactoryToProcess, props);
    }

}

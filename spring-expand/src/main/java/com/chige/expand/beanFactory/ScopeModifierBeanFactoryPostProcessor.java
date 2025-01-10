package com.chige.expand.beanFactory;

import com.chige.expand.domain.BeanA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author wangyc
 * @Description 修改 Bean 定义：可以修改 Bean 的作用域、初始化和销毁方法等定义信息
 * @Date 2025/1/8 23:22
 */
public class ScopeModifierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanA = beanFactory.getBeanDefinition("beanA");
        beanA.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}

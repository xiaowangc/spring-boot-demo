package com.chige.expand.aware;

import com.chige.expand.domain.BeanA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @Author wangyc
 * @Description 实现BeanFactoryAware获取到beanFactory，实现对bean的相关处理
 * @Date 2025/1/10 14:59
 */
public class CustomerBeanFactory implements BeanFactoryAware {

    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private void handleBean(String beanName) {
        //动态获取bean
        BeanA bean1 = beanFactory.getBean(BeanA.class);
        boolean containsBean = beanFactory.containsBean(beanName);
        Object bean = beanFactory.getBean(beanName);
        Class<?> type = beanFactory.getType(beanName);
    }
}

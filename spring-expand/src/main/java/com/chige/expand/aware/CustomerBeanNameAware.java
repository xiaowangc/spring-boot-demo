package com.chige.expand.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @Author wangyc
 * @Description 触发时机：触发点在bean的初始化之前，也就是postProcessBeforeInitialization之前
 * @Date 2025/1/10 14:44
 */
public class CustomerBeanNameAware implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}

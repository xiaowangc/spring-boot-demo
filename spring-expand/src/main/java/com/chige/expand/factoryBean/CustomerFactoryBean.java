package com.chige.expand.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author wangyc
 * @Description 自定义bean定制逻辑，自己实现bean的定义和生成过程
 * @Date 2025/1/10 16:18
 */
public class CustomerFactoryBean implements FactoryBean<ComplexObject> {
    @Override
    public ComplexObject getObject() throws Exception {
        return lazy();
    }


    /**
     * 懒加载bean,只有获取时才创建
     * @return
     */
    private ComplexObject lazy() {
        return new ComplexObject();
    }

    @Override
    public Class<?> getObjectType() {
        return ComplexObject.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

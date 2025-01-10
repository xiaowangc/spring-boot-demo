package com.chige.expand.bean;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author wangyc
 * @Description 介于postProcessBeforeInitialization 和 postProcessAfterInitialization 之间
 * @Date 2025/1/10 16:06
 */
public class CustomerInitializingBean implements InitializingBean {

    private String name;

    /**
     * @Postconstruct 注解的方法执行早于afterPropertiesSet方法，两者都可以实现差不多的功能
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.init();
        this.setName();
    }


    private void setName() {
        this.name = "设置初始化值";
    }

    private void init() {
        System.out.println("一些初始化的动作");
    }

    /**
     * 资源的初始化加载
     */
    private void resourceInit() {
        System.out.println("资源的初始化加载");
    }
}

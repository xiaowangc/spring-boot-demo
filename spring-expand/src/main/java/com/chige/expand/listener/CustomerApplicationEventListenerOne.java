package com.chige.expand.listener;


import org.springframework.context.ApplicationListener;

/**
 * @Author wangyc
 * @Description 自定义事件监听器
 * @Date 2025/1/10 15:18
 */
public class CustomerApplicationEventListenerOne implements ApplicationListener<CustomerEventOne> {


    @Override
    public void onApplicationEvent(CustomerEventOne event) {

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}

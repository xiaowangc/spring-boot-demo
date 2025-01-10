package com.chige.expand.listener;


import org.springframework.context.ApplicationListener;

/**
 * @Author wangyc
 * @Description 自定义事件监听器
 * @Date 2025/1/10 15:18
 */
public class CustomerApplicationEventListenerTwo implements ApplicationListener<CustomerEventTwo> {


    @Override
    public void onApplicationEvent(CustomerEventTwo event) {

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}

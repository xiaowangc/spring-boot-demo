package com.chige.expand.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2025/1/10 15:14
 */
public class CustomerEventTwo extends ApplicationEvent {

    private String eventName;

    public CustomerEventTwo(String eventName) {
        super(eventName);
    }



}
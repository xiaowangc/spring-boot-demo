package com.chige.expand.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @Author wangyc
 * @Description 统一自定义事件发布的入口，可指定满足多种业务的事件发布
 * @Date 2025/1/10 15:06
 */
public class CustomerApplicationEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    private void publishEventOne(String eventName) {
        //发布自定义业务事件1
        ApplicationEvent customerEvent = new CustomerEventOne("自定义事件");
        applicationEventPublisher.publishEvent(customerEvent);
    }

    /**
     * 自定义业务事件2
     * @param eventName
     */
    private void publishEventTwo(String eventName) {
        ApplicationEvent customerEvent = new CustomerEventTwo(eventName);
        applicationEventPublisher.publishEvent(customerEvent);
    }
}

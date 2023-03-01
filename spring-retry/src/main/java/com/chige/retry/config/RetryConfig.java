package com.chige.retry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.retry.support.RetryTemplateBuilder;

/**
 * @author wangyc
 * @date 2023/3/1
 */
@Configuration
public class RetryConfig {

    @Bean
    public RetryTemplate getRetryTemplate() throws Throwable {
        TimeoutRetryPolicy timeoutRetryPolicy = new TimeoutRetryPolicy();
        timeoutRetryPolicy.setTimeout(3000);
        RetryTemplate retryTemplate = new RetryTemplateBuilder()
                .customPolicy(timeoutRetryPolicy)
                .build();
        retryTemplate.execute((RetryCallback<Object, Throwable>) retryContext -> null);
        return retryTemplate;
    }
}

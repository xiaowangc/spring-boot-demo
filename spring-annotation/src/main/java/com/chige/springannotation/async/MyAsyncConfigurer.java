package com.chige.springannotation.async;

import com.chige.springannotation.util.ThreadPoolTaskExecutorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Async 应用自定义线程池 - 实现方式二
 *  继承AsyncConfigurerSupport类，自定义ThreadPoolTaskExecutor，实现getAsyncExecutor()方法
 */
@EnableAsync
@Configuration("myAsyncConfigurer")
public class MyAsyncConfigurer extends AsyncConfigurerSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAsyncConfigurer.class);

    @Bean
    public ThreadPoolTaskExecutor asyncTaskExecutor() {
        return ThreadPoolTaskExecutorUtils.getTaskExecutor();
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            LOGGER.info("执行异步任务方法:{}, 入参：{}, 异常原因：", method, objects, throwable);
        };
    }

}

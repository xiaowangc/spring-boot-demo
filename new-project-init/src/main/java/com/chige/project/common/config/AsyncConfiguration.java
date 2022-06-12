package com.chige.project.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  @Async 应用自定义线程池 - 实现方式一
 *  实现AsyncConfigurer接口，自定义ThreadPoolTaskExecutor类，实现getAsyncExecutor()方法
 */
@EnableAsync
@Configuration
public class AsyncConfiguration implements AsyncConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);

    @Bean("updateTaskExecutor")
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        final int CORE_POOL_SIZE = 4;
        final int MAX_POOL_SIZE = 5;
        final int QUEUE_CAPACITY = 10000;
        int awaitTerminationSeconds = 5;
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("taskExecutor-prefix");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        executor.setKeepAliveSeconds(60);
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            LOGGER.info("执行异步任务方法:{}, 入参：{}, 异常原因：", method, objects, throwable);
        };
    }
}

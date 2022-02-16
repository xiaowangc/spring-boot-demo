package com.chige.springannotation.async;

import com.chige.springannotation.util.ThreadPoolTaskExecutorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * @Async 应用自定义线程池 - 实现方式三
 *  直接自定义线程池: 下面自定义了两个线程池，在使用@Async注解时可以直接指定线程池名称
 *
 */
@EnableAsync
@Configuration(value = "myTaskExecutorConfig")
public class MyTaskExecutorConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTaskExecutorConfig.class);

    @Bean(name = AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
    public Executor taskExecutor1() {
        return ThreadPoolTaskExecutorUtils.defaultTaskExecutor();
    }

    @Bean("myTaskExecutor")
    public Executor taskExecutor2() {
        return ThreadPoolTaskExecutorUtils.getTaskExecutor();
    }
}

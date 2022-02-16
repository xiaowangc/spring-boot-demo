//package com.chige.springannotation.async;
//
//import com.chige.springannotation.util.ThreadPoolTaskExecutorUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurer;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
///**
// *  @Async 应用自定义线程池 - 实现方式一
// *  实现AsyncConfigurer接口，自定义ThreadPoolTaskExecutor类，实现getAsyncExecutor()方法
// */
//@Configuration(value = "myAsyncConfiguration")
//public class AsyncConfiguration implements AsyncConfigurer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);
//
//    @Bean("myAsyncTaskExecutor")
//    public ThreadPoolTaskExecutor executor() {
//        return ThreadPoolTaskExecutorUtils.getTaskExecutor();
//    }
//
//    @Override
//    public Executor getAsyncExecutor() {
//        return executor();
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return (throwable, method, objects) -> {
//            LOGGER.info("执行异步任务方法:{}, 入参：{}, 异常原因：", method, objects, throwable);
//        };
//    }
//}

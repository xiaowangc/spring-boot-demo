package com.chige.springannotation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTaskExecutorUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolTaskExecutorUtils.class);

    private ThreadPoolTaskExecutorUtils() {}

    /**
     *  创建默认线程池
     */
    public static ThreadPoolTaskExecutor defaultTaskExecutor() {
        return createTaskExecutor("DEFAULT_TASK_EXECUTOR-");
    }

    public static ThreadPoolTaskExecutor getTaskExecutor() {
        return createTaskExecutor("myTaskExecutor-");
    }

    /**
     *  创建线程池
     */
    private static ThreadPoolTaskExecutor createTaskExecutor(String threadNamePrefix) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        final int CORE_POOL_SIZE = 5;
        final int MAX_POOL_SIZE = 50;
        final int QUEUE_CAPACITY = 10;
        int awaitTerminationSeconds = 5;
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        executor.initialize();
        return executor;
    }

}

package com.chige.springannotation.async;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Async注解 使用说明、最佳实践
 * 使用说明：该注解可以使用在方法上，使之成为异步方法。调用者将在调用方法时立即返回，方法的实际执行将交给Spring TaskExecutor的任务中，由指定的线程池来执行该任务
 * 建议： 在实际项目应用中，@Async调用线程池，推荐使用自定义线程池的模式
 *
 */
@Slf4j
@Service
public class AsyncDemo {

    private static final ThreadPoolExecutor SELECT_POOL_EXECUTOR = new ThreadPoolExecutor(10, 20, 5000,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), new ThreadFactoryBuilder().setNameFormat("selectThreadPoolExecutor-%d").build());
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    /**
     *  异步方法一：无返回值调用
     * 对于返回值是void，异常会被AsyncUncaughtExceptionHandler处理掉
     */
    @Async
    public void asyncInvokeWithException(String s) {
        log.info(">>> 无返回值调用, param={}", s);
        throw new IllegalArgumentException(s);
    }

    /**
     *  异步方法二：返回Future
     *  对于返回值是Future，不会被AsyncUncaughtExceptionHandler处理，需要我们在方法中捕获异常并处理
     *  或者在调用方调用Future.get时捕获异常进行处理
     */
    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture, parementer={}", i);
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<String>("success:" + i);
            throw new IllegalArgumentException("a");
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        } catch(IllegalArgumentException e) {
            future = new AsyncResult<String>("error-IllegalArgumentException");
        }
        return future;
    }

    /**
     * 异步方法三：CompletableFuture 并不使用@Async注解，可达到调用系统线程池处理业务的功能。
     * CompletionStage代表异步计算过程中的某一个阶段，一个阶段完成以后可能会触发另外一个阶段
     * 一个阶段的计算执行可以是一个Function，Consumer或者Runnable。
     * 比如：stage.thenApply(x -> square(x)).thenAccept(x -> System.out.print(x)).thenRun(() -> System.out.println())。
     *
     * 在Java8中，CompletableFuture提供了非常强大的Future的扩展功能，可以帮助我们简化异步编程的复杂性，并且提供了函数式编程的能力，
     * 可以通过回调的方式处理计算结果，也提供了转换和组合 CompletableFuture 的方法。
     *  1、它可能代表一个明确完成的Future，也有可能代表一个完成阶段（ CompletionStage ），它支持在计算完成以后触发一些函数或执行某些动作。
     *  2、它实现了Future和CompletionStage接口。
     */
    public void handleAsyncMethod() throws ExecutionException, InterruptedException {
        // 获取总条数
        CompletableFuture<Integer> countFuture = CompletableFuture
                .supplyAsync(this::countTradeLog, SELECT_POOL_EXECUTOR);
        // 同步阻塞
        CompletableFuture.allOf(countFuture).join();
        // 获取结果
        countFuture.get();
    }

    public int countTradeLog() {
        return atomicInteger.addAndGet(2);
    }

    @Async(value = "myTaskExecutor")
    public void userMyTaskExecutor(int i) {
        log.info(">>> i = {}, 验证是否当前执行方法的任务管理器是自定义的:{}", i, Thread.currentThread().getName());
    }

}


/**
 * SpringBoot中启用@Async: 在程序入口处添加@EnableAsync注解
 * @Async 默认使用SimpleAsyncTaskExecutor线程池，但不建议使用改线程池，建议自定义线程池
 * 异步的方法有：
 *  1、最简单的异步调用，返回值为void，有入参
 *  2、存在返回值，常调用返回Future。
 *  3、存在返回值 - CompletableFuture实现异步方法调用功能
 *
 * 【不建议的原因】
 * @Async 默认异步配置使用的是SimpleAsyncTaskExecutor，该线程池默认来一个任务创建一个线程，若系统中不断的创建线程，最终会导致系统占用内存过高，引发OutOfMemoryError错误。
 * 针对线程创建问题，SimpleAsyncTaskExecutor提供了限流机制，通过concurrencyLimit属性来控制开关：
 *  （1）当concurrencyLimit>=0时开启限流机制，
 *  （2）默认关闭限流机制 即 concurrencyLimit=-1
 *  当关闭情况下，会不断创建新的线程来处理任务。基于默认配置，SimpleAsyncTaskExecutor并不是严格意义的线程池，达不到线程复用的功能。
 *
 * 【建议的原因】
 * @Async 应用自定义线程池,一下有三种不同的实现方式
 *  方式（1）重新实现接口AsyncConfigurer；
 *  方式（2）继承AsyncConfigurerSupport；
 *  方式（3）配置由自定义的TaskExecutor替代内置的任务执行器。如 MyTaskExecutorConfig.class 即自定义多个线程池
 * 通过查看Spring源码关于@Async的默认调用规则，会优先查询源码中实现AsyncConfigurer这个接口的类，实现这个接口的类为AsyncConfigurerSupport。
 * 但默认配置的线程池和异步处理方法均为空，所以，无论是继承(如 MyAsyncConfigurer.class) 或者重新实现接口（如 AsyncConfiguration.class），都需指定一个线程池。
 * 且重新实现 public Executor getAsyncExecutor()方法。
 *
 */
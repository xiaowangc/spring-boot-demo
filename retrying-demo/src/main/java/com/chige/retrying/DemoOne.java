package com.chige.retrying;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class DemoOne {

    public static void test1() {
        Callable<Boolean> callable = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                // 需要重试的业务代码
                return true; // do something useful here
            }
        };

        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>isNull())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        try {
            retryer.call(callable);
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {

    }

    public Retryer<Response> retry() {
        // 定义重试机制
        Retryer<Response> retryer = RetryerBuilder.<Response>newBuilder()
                .retryIfException()
                .retryIfResult(response -> !ResponseCode.SUCCESS.getCode().equals(response.getCode()))

                .build();


        return retryer;
    }

    public static void main(String[] args) {
        test1();
    }
}
// guava-retrying简答使用：https://blog.csdn.net/ls490447406/article/details/103806583
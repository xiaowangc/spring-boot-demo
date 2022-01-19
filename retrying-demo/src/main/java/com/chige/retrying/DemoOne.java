package com.chige.retrying;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import com.google.common.util.concurrent.FakeTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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
                .retryIfRuntimeException()
                .retryIfExceptionOfType(ResponseException.class)
                .retryIfException()
                .retryIfException(Predicates.equalTo(new ResponseException("异常")))
                .retryIfResult(Predicates.isNull()) //如果返回参数是null,则需要重试
                // 返回状态码为非成功状态码，需要重试
                .retryIfResult(response -> !ResponseCode.SUCCESS.getCode().equals(response.getCode()))
                // 等待策略：每次请求间隔5s
                .withWaitStrategy(WaitStrategies.fixedWait(5, TimeUnit.SECONDS))
                // 停止策略：尝试请求6次后，如果还是失败，则停止重试
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                // 时间限制：某次请求不得超过30秒
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(30, TimeUnit.SECONDS))
                //
                .withRetryListener(new WebResponseListener())
                .build();

        return retryer;
    }

    public static void main(String[] args) {
        // 验证：
        /**
         *  1、模拟接口返回异常
         *  2、模拟接口返回错误
         *  3、模拟接口第二次重试成功
         *  4、模拟接口达到设置重试次数还是失败的情况
         *  5、模拟接口相应时间过慢的情况
         */
        test1();
        DemoOne demoOne = new DemoOne();
        Retryer<Response> retry = demoOne.retry();
        try {
            retry.call(() -> {
                Response response = new Response();
                response.setCode(1);
                response.setMsg("success");
                return response;
            });
        } catch (ExecutionException | RetryException e) {
            e.printStackTrace();
        }
    }
}
// guava-retrying简答使用：https://blog.csdn.net/ls490447406/article/details/103806583
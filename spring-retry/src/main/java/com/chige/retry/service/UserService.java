package com.chige.retry.service;

import com.chige.retry.exception.RetryException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author wangyc
 * @date 2023/3/1
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private RetryTemplate template;

    @PostConstruct
    public void init() throws Throwable {
        System.out.println(template);
    }

    @Retryable(recover = "retryMethod",value = {RuntimeException.class, RetryException.class}, maxAttempts = 1,
            backoff = @Backoff(delay = 1000L, multiplier = 2))
    public Integer doMethod() {
        int i = RandomUtils.nextInt(10, 20);
        if (i % 2 == 0) {
            log.error("随机数为偶数，触发重试!");
            throw new RetryException("随机数不能为偶数.");
        }
        return i;
    }

    /**
     * 方法重试的补偿方法
     * 当重试maxAttempts次后还是抛出异常，则进入此方法
     * @return
     */
    @Recover
    public Integer retryMethod(RetryException retryException) {
        System.out.println("调用超过2次");
        return 10;
    }
}

/**
 * 注意：
 * 1、@Retryable注解中的value为可捕捉的异常类型，如果方法中抛出了其他异常类型，则无法重试
 * @Recover 注解是重试几次后最终的兜底补偿，补偿方法的返回值类型需要与原方法的返回值类型一致
 * 2、补偿方法的入参是异常类型，且与重试方法doMethod抛出的异常类型一致
 *
 * 参考文章：https://blog.csdn.net/qq1353424111/article/details/111468955
 * https://www.cnblogs.com/haoming1100/articles/9949028.html
 */

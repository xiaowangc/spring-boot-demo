package com.chige.retry.exception;

/**
 * @author wangyc
 * @date 2023/3/1
 */
public class RetryException extends RuntimeException {

    private String msg;

    public RetryException(String message) {
        super(message);
        this.msg = message;
    }
}

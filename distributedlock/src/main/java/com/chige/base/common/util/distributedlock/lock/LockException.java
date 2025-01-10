package com.chige.base.common.util.distributedlock.lock;


/**
 * 锁异常
 *
 * @author linyc
 * @version LockException 2021/8/13 9:29
 */
public class LockException extends RuntimeException {

    public LockException(String msg) {
        super(msg);
    }

}
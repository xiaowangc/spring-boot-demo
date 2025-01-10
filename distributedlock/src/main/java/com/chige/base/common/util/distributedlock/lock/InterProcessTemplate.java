package com.chige.base.common.util.distributedlock.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 执行模板
 *
 * @version InterProcessTemplate 2021/8/13 9:51
 */
public class InterProcessTemplate {

    private static final Logger logger = LoggerFactory.getLogger(InterProcessTemplate.class);

    public void process(InterProcessCallback callback) {
        InterProcess tableLock;
        try {
            tableLock = callback.doLock();
        } catch (LockException lockException) {
            throw lockException;
        } catch (Exception e) {
            logger.error("lock has unknown error", e);
            throw new LockException("锁未知异常");
        }
        try {
            callback.doProcess();
        } finally {
            InterProcessLockUtils.releaseQuietly(tableLock);
        }
    }
}
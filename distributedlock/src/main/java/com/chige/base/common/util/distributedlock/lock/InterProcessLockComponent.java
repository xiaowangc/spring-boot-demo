package com.chige.base.common.util.distributedlock.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁组件
 * @version InterProcessLockComponent 2021/8/13 9:27
 */
@Component
public class InterProcessLockComponent {

    private static final Logger logger = LoggerFactory.getLogger(InterProcessLockComponent.class);

    @Resource
    private RedissonClient redissonClient;

    /**
     * @param txId
     * @param type
     * @return
     */
    public InterProcess acquire(String txId, String type) {
        String lockId = InterProcessLockUtils.LOCK_ROOT_PATH + "." + type + "-" + txId;
        RLock lock = this.redissonClient.getLock(lockId);
        InterProcess interProcess = new InterProcess(lockId, lock);
        boolean isLock = false;
        try {
            isLock = lock.tryLock(0, TimeUnit.MILLISECONDS);
            if (!isLock) {
                throw new LockException("cannot acquire lock for [" + txId + ", " + type + "]");
            }
        } catch (InterruptedException e) {
            logger.error("lock id: " + lockId, e);
            throw new LockException("lock has exception, id [" + lockId + "]");
        }
        return interProcess;
    }

    public InterProcess rotateAcquire(String txId, String type) {
        String lockId = InterProcessLockUtils.LOCK_ROOT_PATH + "." + type + "-" + txId;
        RLock lock = this.redissonClient.getLock(lockId);
        InterProcess interProcess = new InterProcess(lockId, lock);
        boolean isLock = false;
        try {
            int times = 5;
            isLock = lock.tryLock(0, TimeUnit.MILLISECONDS);
            while (!isLock && times > 0) {
                Thread.sleep(50);
                isLock = lock.tryLock(0, TimeUnit.MILLISECONDS);
                logger.info("尝试获取锁。。。");
                times--;
            }
            if(!isLock){
                throw new LockException("cannot acquire lock for [" + txId + ", " + type + "]");
            }
        } catch (InterruptedException e) {
            logger.error("lock id: " + lockId, e);
            throw new LockException("lock has exception, id [" + lockId + "]");
        }
        return interProcess;
    }
}
package com.chige.base.common.util.distributedlock.lock;

import org.redisson.api.RLock;

/**
 * @version InterProcess 2021/8/13 9:29
 */
public class InterProcess {

    private String lockId;
    private RLock lock;

    public InterProcess() {
    }

    public InterProcess(String lockId, RLock lock) {
        this.lockId = lockId;
        this.lock = lock;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public RLock getLock() {
        return lock;
    }

    public void setLock(RLock lock) {
        this.lock = lock;
    }
}
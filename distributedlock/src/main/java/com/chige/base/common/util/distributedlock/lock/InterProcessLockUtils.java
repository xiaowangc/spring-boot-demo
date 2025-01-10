package com.chige.base.common.util.distributedlock.lock;

import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version InterProcessLockUtils 2021/8/13 9:30
 */
public class InterProcessLockUtils {

    private InterProcessLockUtils() {}

    private static final Logger logger = LoggerFactory.getLogger(InterProcessLockUtils.class);
    private static final String PROJECT_NAME = "distributedlock";
    public static final String LOCK_ROOT_PATH = PROJECT_NAME + ".distribute-locker";

    public static void releaseQuietly(InterProcess interProcess) {
        RLock lock = interProcess.getLock();
        try {
            lock.unlock();
        } catch (Exception e) {
            logger.error("release lock has unknown error", e);
        }
    }
}
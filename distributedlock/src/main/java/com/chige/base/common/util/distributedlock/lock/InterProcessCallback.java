package com.chige.base.common.util.distributedlock.lock;


/**
 * @version InterProcessCallback 2021/8/13 9:50
 */
public interface InterProcessCallback {

    InterProcess doLock();

    void doProcess();

}
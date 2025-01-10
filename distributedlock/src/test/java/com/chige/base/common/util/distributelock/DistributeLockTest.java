package com.chige.base.common.util.distributelock;

import com.chige.base.common.util.distributedlock.App;
import com.chige.base.common.util.distributedlock.lock.InterProcess;
import com.chige.base.common.util.distributedlock.lock.InterProcessLockComponent;
import com.chige.base.common.util.distributedlock.lock.LockKeys;
import com.chige.base.common.util.distributedlock.lock.InterProcessCallback;
import com.chige.base.common.util.distributedlock.lock.InterProcessTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangyc
 * @date 2023/5/12
 */
@SpringBootTest(classes = App.class)
public class DistributeLockTest {

    private InterProcessTemplate template = new InterProcessTemplate();

    private InterProcessLockComponent interProcessLockComponent;

    @Autowired
    public void setInterProcessLockComponent(InterProcessLockComponent interProcessLockComponent) {
        this.interProcessLockComponent = interProcessLockComponent;
    }

    @Test
    public void test() {
        this.template.process(new InterProcessCallback() {
            @Override
            public InterProcess doLock() {
                return interProcessLockComponent.rotateAcquire(LockKeys.LOCK_NAME1, "userId");
            }

            @Override
            public void doProcess() {
                //走业务逻辑
                System.out.println("获取到分布式锁");
            }
        });
    }

}

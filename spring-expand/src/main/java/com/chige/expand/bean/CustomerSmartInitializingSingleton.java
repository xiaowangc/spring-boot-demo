package com.chige.expand.bean;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @Author wangyc
 * @Description 触发时机：在单例bean初始化之后，可做一些数据缓存，全局任务调度等操作
 * @Date 2025/1/10 16:11
 */
public class CustomerSmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        loadCache();
        startTask();
    }


    private void loadCache() {
        System.out.println("加载一些缓存");
    }

    private void startTask() {
        System.out.println("bean加载完后，启动任务.");
    }
}

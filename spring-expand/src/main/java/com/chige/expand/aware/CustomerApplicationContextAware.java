package com.chige.expand.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

/**
 * @Author wangyc
 * @Description 获取到ApplicationContext应用上下文，可实现的操作有：
 * 1. 动态获取bean、管理bean
 * 2. 实现国际资源加载
 * 3. 环境配置资源加载
 * 4. 监听事件
 * 5. 资源文件加载
 * @Date 2025/1/10 15:02
 */
public class CustomerApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Environment getEnv() {
        return applicationContext.getEnvironment();
    }


}

package com.chige.expand.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;

import java.io.InputStream;

/**
 * @Author wangyc
 * @Description Bean 获取到加载它的 ClassLoader
 * @Date 2025/1/10 14:53
 */
public class CustomerBeanClassLoaderAware implements BeanClassLoaderAware {

    private ClassLoader classLoader;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        //获取bean加载的类加载器
        this.classLoader = classLoader;
    }


    /**
     * 作用：通过类加载器可实现多种场景功能
     * 1. 加载类
     * 2. 检查类的可用性，加载中可能出现类找不到的异常
     * 3. 加载资源文件
     *
     * @param className
     */
    public void loadClass(String className) {

        try {
            Class<?> clazz = classLoader.loadClass(className);
            System.out.println("已加载类：" + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("类未找到：" + className);
        }
    }

    /**
     * 加载资源文件
     */
    public void loadResource(String resourcePath) {
        InputStream inputStream = classLoader.getResourceAsStream(resourcePath);
        if (inputStream != null) {
            System.out.println("资源已加载：" + resourcePath);
        } else {
            System.out.println("资源未找到：" + resourcePath);
        }
    }
}

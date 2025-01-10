package com.chige.expand.bean;

import com.chige.expand.domain.BeanA;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.lang.Nullable;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author wangyc
 * @Description 两个基本的Bean初始化回调方法，在属性赋值前后执行
 * @Date 2025/1/9 17:32
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {

    /**
     * 实例化之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logAndMonitorStart(bean, beanName);
        customerModifyBeanBefore(bean, beanName);
        proxyBean(bean, beanName);
        return customerAutowireBeanPostProcessor(bean, beanName);
    }

    /**
     * 实例化之后，属性赋值之前
     */
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logAndMonitoryEnd(bean, beanName);
        return customerModifyBeanAfter(bean, beanName);
    }

    private Object customerModifyBeanBefore(Object bean, String beanName) {
        if (bean instanceof BeanA) {
            System.out.println("bean初始化前: " + beanName);
            ((BeanA) bean).setName("HELLO");
        }
        return bean;
    }

    private Object customerModifyBeanAfter(Object bean, String beanName) {
        if (bean instanceof BeanA) {
            System.out.println("bean初始化后: " + beanName);
        }
        return bean;
    }

    /**
     * 生成 Bean 的代理对象，用于 AOP（面向切面编程）或其他用途。
     */
    private Object proxyBean(Object bean, String beanName) {
        if (bean instanceof BeanA) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("Before method: " + method.getName());
                    Object result = proxy.invokeSuper(obj, args);
                    System.out.println("After method: " + method.getName());
                    return result;
                }
            });

            return enhancer.create();
        }
        return bean;
    }

    /**
     * 记录 Bean 的初始化过程，进行性能监控、日志记录等
     */
    private Object logAndMonitorStart(Object bean, String beanName) {
        System.out.println("开始记录日志");
        return bean;
    }

    private Object logAndMonitoryEnd(Object bean, String beanName) {
        System.out.println("结束日志记录");
        return bean;
    }


    /**
     * 自动装配：
     */
    private Object customerAutowireBeanPostProcessor(Object bean, String beanName) {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(AutowireCustom.class)) {
                declaredField.setAccessible(true);
                try {
                    declaredField.set(bean, "Injected Value");
                } catch (IllegalAccessException e) {
                    throw new BeansException("Failed to autowire field: " + declaredField.getName(), e) {
                    };
                }
            }
        }
        return bean;
    }


}

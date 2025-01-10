package com.chige.expand.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2025/1/10 00:06
 */
public class CustomerInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return swapBeanBeforeInstantiation(beanClass, beanName);
    }

    /**
     * bean实例化之后、属性加载之前
     * @param bean
     * @param beanName
     * @return 返回true 再后续会执行postProcessProperties方法
     * @throws BeansException
     */
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之后的 Bean: " + beanName);
        return true;
    }

    @Nullable
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    /**
     * bean 初始化之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        dependencyInjectionControlPostProcessor(bean, beanName);
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化bean之后");
        return bean;
    }

    /**
     * bean实例化之前 替换bean,返回一个代理对象
     * @return
     */
    private Object swapBeanBeforeInstantiation(Class<?> beanClass, String beanName) {
        if (beanClass == MyBean.class) {
            System.out.println("bean实例化之前");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);

            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("调用方法: " + method.getName());
                    return proxy.invokeSuper(obj, args);
                }
            });
            return enhancer.create();
        }

        return null;
    }

    private Object dependencyInjectionControlPostProcessor(Object bean, String beanName) {
        if (bean instanceof MyBean) {
            System.out.println("实例化之后控制依赖注入");
            return false; //不进行默认的依赖注入
        }
        return true;
    }


    /**
     * 修改属性
     * @return
     */
    private Object propertyModificationPostProcessor(PropertyValues pvs, Object bean, String beanName) {
        if (bean instanceof MyBean) {
            System.out.println("设置属性值之前");

        }

        return pvs;
    }


}

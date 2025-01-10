package com.chige.expand.register;

import com.chige.expand.domain.BeanA;
import com.chige.expand.domain.ConditionalBean;
import com.chige.expand.domain.MyAnnotationBean;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author wangyc
 * @Description 容器级后置处理器；【增删改查BeanDefinition】
 * 1. 修改现有的 BeanDefinition：可以在 Bean 实例化之前修改现有的 BeanDefinition，如更改其属性值或作用域
 * 2. 扫描和注册自定义注解的 Bean
 * @Date 2025/1/8 23:31
 */
public class CustomerBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        conditionalRegisterBeanDefinition(registry);

        modifyBeanDefinition(registry);

        customerAnnotationBeanRegister(registry);

        customerRedisBeanRegistry(registry);

    }

    private void conditionalRegisterBeanDefinition(BeanDefinitionRegistry registry) {
        System.out.println("在 postProcessBeanDefinitionRegistry 中根据条件注册 Bean");
        if (someConditional()) {
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(ConditionalBean.class).getBeanDefinition();
            registry.registerBeanDefinition("conditionalBean", beanDefinition);
        }

    }

    private boolean someConditional() {
        return true;
    }

    private void modifyBeanDefinition(BeanDefinitionRegistry registry) {
        System.out.println("在 postProcessBeanDefinitionRegistry 中修改现有的 BeanDefinition");
        if (registry.containsBeanDefinition("beanA")) {
            BeanDefinition beanDefinition = registry.getBeanDefinition("beanA");
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            propertyValues.add("key1", "val1");
        }
    }

    /**
     * 扫描和注册自定义注解的 Bean：实现自定义注解的扫描逻辑，并动态注册这些注解标注的
     * @param registry
     */
    private void customerAnnotationBeanRegister(BeanDefinitionRegistry registry) {
        System.out.println("在 postProcessBeanDefinitionRegistry 中扫描并注册自定义注解的 Bean");
        // 自定义扫描逻辑，假设找到一个类 MyAnnotatedBean
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(MyAnnotationBean.class)
                .getBeanDefinition();
        registry.registerBeanDefinition("myAnnotatedBean", beanDefinition);
    }

    /**
     * 判断使用Redis 还是本地缓存并注册相应的缓存bean
     */
    private void customerRedisBeanRegistry(BeanDefinitionRegistry registry) {
        System.out.println("在 postProcessBeanDefinitionRegistry 中根据条件注册缓存实现类");
        // 检查 Redis 依赖是否存在
        try {
            Class.forName("redis.clients.jedis.Jedis");
            System.out.println("检测到 Redis 依赖，注册 RedisCacheService");
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(RedisCacheService.class).getBeanDefinition();
            registry.registerBeanDefinition("cacheService", beanDefinition);

        } catch (ClassNotFoundException e) {
            System.out.println("未检测到 Redis 依赖，注册 LocalCacheService");
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(LocalCacheService.class).getBeanDefinition();
            registry.registerBeanDefinition("localCacheService", beanDefinition);
        }
    }

    /**
     * Mybatis 是利用的BeanFactoryPostProcessor去注册的mapper
     * 核心点：MapperScannerConfigurer
     * 通过扫描指定的包路径，找到所有标注了 @Mapper 注解（或其他指定注解）的接口，并将这些接口注册为 Spring 的 BeanDefinition
     */
    static class CustomerMapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {
        private String basePackage;
        private ApplicationContext applicationContext;

        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);

            scanner.setResourceLoader(this.applicationContext);
            scanner.registerFilters();
            //扫描指定的包路径，找到所有符合条件的 Mapper 接口，并将它们注册为 Spring 的 BeanDefinition
            scanner.scan(basePackage);
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }


    static class RedisCacheService {

    }

    static class LocalCacheService {

    }
}

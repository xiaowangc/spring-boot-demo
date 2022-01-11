package com.chige.openfeign.config;

import com.chige.interceptor.PersonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 该配置类，实现 WebMvcConfigurer 接口，实现 SpringMVC 的自定义配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer  {

    @Autowired
    private PersonInterceptor personInterceptor;
    //实现添加自定义拦截器的方法
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //可以拦截所有路径
        registry.addInterceptor(personInterceptor).addPathPatterns("/**");
    }

}

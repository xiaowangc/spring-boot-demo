package com.chige.config;

import com.chige.interceptor.PersonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private PersonInterceptor personInterceptor;
    //实现添加拦截器的方法
    public void addInterceptors(InterceptorRegistry registry){
        //可以拦截所有路径
        registry.addInterceptor(personInterceptor).addPathPatterns("/**");
    }

}

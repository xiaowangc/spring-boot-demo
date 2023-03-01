package com.chige.nacos.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyc
 * @date 2022/12/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientApplication {
    private final static Logger log = LoggerFactory.getLogger(NacosClientApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
        log.info("Nacos Client 启动成功");
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        WebApplicationContext webApplicationContext = RequestContextUtils.findWebApplicationContext(request);
        ServletContext servletContext = webApplicationContext.getServletContext();

    }
}

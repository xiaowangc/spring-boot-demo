package com.chige.aop;

import cn.hutool.json.JSONUtil;
import com.chige.util.RequestReadUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author wangyc
 * @date 2021/3/28 12:03
 */
@Slf4j
@Aspect
@Component
public class LogResponseAop {

    /** 声明一个切点
     *  Controller包下所有请求
     */
    @Pointcut(value = "execution(* com.chige..*..controller..*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        long start = System.currentTimeMillis();
        String requestMethod = request.getMethod();
        String requestURL = String.valueOf(request.getRequestURL());
        String args = RequestReadUtils.read(request);
        String startUUID = UUID.randomUUID().toString();
        log.info("请求方法：{}，请求地址：{}，入参：[{}],traceId:{}",requestMethod,requestURL,args,startUUID);
        Object result = proceedingJoinPoint.proceed();
        log.info("traceId:{},请求方法：{}，请求地址：{}，入参:{}, 返参：{},用时：{}秒",
                startUUID,
                requestMethod,
                requestURL,
                args,
                JSONUtil.toJsonStr(result),
                (System.currentTimeMillis() - start) / 1000);
        return result;
    }




}

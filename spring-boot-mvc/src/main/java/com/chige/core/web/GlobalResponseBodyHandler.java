package com.chige.core.web;

import com.chige.response.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *  拦截 Controller 的返回结果，进行相应的处理，最后在返回处理后的结果
 */
@ControllerAdvice(basePackages = "com.chige.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // 返回true表示拦截 Controller 所有 API 接口的返回结果
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (o instanceof CommonResult) {
            return o;
        }
        // 如果不是，则包装成CommonResult
        return CommonResult.success(o);
    }
}

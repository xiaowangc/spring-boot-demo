package com.chige.core.web;


import com.chige.exception.ServerException;
import com.chige.response.CommonResult;
import com.chige.response.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *  统一全局异常处理
 */
@ControllerAdvice(basePackages = "com.chige.controller")
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**  业务类的异常
     * 处理 ServiceException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServerException.class)
    public CommonResult serverExceptionHandler(HttpServletRequest request,ServerException serverException) {
        logger.debug("serverException handler:",serverException);
        return CommonResult.error(serverException.getCode(),serverException.getMessage());
    }

    /**
     * 处理 MissingServletRequestParameterException 异常
     * SpringMVC 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(HttpServletRequest request,ServerException serverException) {
        logger.debug("[missingServletRequestParameterExceptionHandler]", serverException);
        // 包装 CommonResult 结果
        return CommonResult.error(ResponseCode.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ResponseCode.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult otherException(HttpServletRequest request,ServerException exception) {
        //记录异常日志
        logger.error("[other exception:]",exception);
        return CommonResult.error(ResponseCode.SYS_ERROR.getCode(),ResponseCode.SYS_ERROR.getMessage());
    }





}



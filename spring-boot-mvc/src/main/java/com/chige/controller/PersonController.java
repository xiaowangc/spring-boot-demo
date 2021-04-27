package com.chige.controller;

import com.chige.response.CommonResult;
import com.chige.response.ResponseCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @RequestMapping("/servlet")
    public CommonResult<Map> say(){
        System.out.println("...PersonController say()");
        CommonResult<Map> commonResult = new CommonResult();
        commonResult.setCode(ResponseCode.SUCCESS.getCode());
        commonResult.setMessage(ResponseCode.SUCCESS.getMessage());
        Map<String,String> map = new HashMap<>();
        map.put("abc","123");
        commonResult.setData(map);
        return commonResult;
    }
}

/**
 *  API 接口是失败的返回呢？我们约定在 Controller 抛出异常, 使用全局异常统一处理
 */

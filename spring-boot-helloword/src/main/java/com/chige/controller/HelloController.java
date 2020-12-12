package com.chige.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello world";
    }
}

/**
    通过@ResponseBody来控制返回给浏览器端的是JSON格式的字符串
 */
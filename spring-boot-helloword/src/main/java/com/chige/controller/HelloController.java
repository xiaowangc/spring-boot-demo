package com.chige.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller 用于返回视图层的信息，可以模板引擎一起使用(如 thymeleaf )
 *
 * @RestController 用于返回json格式的数据信息
 * 注意：如果使用 `模板引擎` 则不能使用@RestController这个注解
 */

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
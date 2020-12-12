package com.chige.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

//错误页方式四：对应于MyCustomizer类
// 类中方法会跳转到指定的是、错误页
@Controller
public class MyErrorController {


    @RequestMapping("/error404")
    public String error404(){
        return "error404";
    }

    //下面的方法是用来测试 全局异常的，当这个MyErrorController中某个方法处理异常时，
    // 全局异常处理类MyExceptionHandler需要捕捉到这个异常，并做相应的处理，返回友好的错误页面
    @RequestMapping("/testError")
    public String errorTest() throws Exception{
        throw new Exception("测试异常");
    }
}

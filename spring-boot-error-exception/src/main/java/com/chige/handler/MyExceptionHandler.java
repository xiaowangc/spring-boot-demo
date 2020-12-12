package com.chige.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Executors;

//全局异常处理 切面思想
@ControllerAdvice //当控制层发生异常时，该注解能够接受到所有异常，接着做相应的处理
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("message",e.getMessage()); //可以将后端处理的异常信息显示到前端中
        return mv;
    }
}

package com.chige.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller 用于返回视图层的信息，可以模板引擎一起使用(如 thymeleaf )
 *
 * @RestController 用于返回json格式的数据信息
 * 注意：如果使用 `模板引擎` 则不能使用@RestController这个注解
 */

@RestController
public class JasyptController {

    @Value("${info.username}")
    private String username;


    @RequestMapping("/jasypt")
    public String jasyptModle(){
        StringBuilder sb = new StringBuilder();
        sb.append(username);
        return sb.toString();
    }

    //vQtmcvRktnQ2VxUzBDsOlQ==


}

package com.chige.springbootvue.controller;

import com.chige.springbootvue.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //TODO 前端请求方法与后端接口出现错误
    @GetMapping("/login")
    public String login(String username,String password){
        System.out.println(username);
        System.out.println(password);
        if ("xiaowang".equals(username) && "123".equals(password)){
            return "success";
        }
        return "error";
    }
}

package com.chige.controller;

import com.chige.openfeign.config.FoodConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class FreemarkerController {

    //方法一：
//    @Value("${food.meat}")
//    private String meat;
//    @Value("${food.rice}")
//    private String rice;
    //方法二：
    @Autowired
    private FoodConfig foodConfig;

    public void test(){
        System.out.println(foodConfig.getMeat());
        System.out.println(foodConfig.getRice());
    }

    @RequestMapping("/ftl")
    public String index(Model model){
        model.addAttribute("now",new Date().toString());
        return "freemaker/index";
    }

    @RequestMapping("/hello")
    public String freemarkerHTML(){
        return "hello world";
    }

    @RequestMapping("/login")
    public String food(Model model){
        model.addAttribute("meat",foodConfig.getMeat());
        model.addAttribute("rice",foodConfig.getRice());
        model.addAttribute(foodConfig);
        return "freemaker/login";
    }


}

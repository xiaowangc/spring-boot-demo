package com.chige.controller;

import com.chige.config.FoodConfig;
import com.chige.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.FontDescriptor;

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

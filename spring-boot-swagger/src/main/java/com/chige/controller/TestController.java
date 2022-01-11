package com.chige.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @author wangyc
 * @date 2021/8/7
 */
@RestController
public class TestController {

    @RequestMapping("/health/test")
    public String test() {
        Properties properties = System.getProperties();
        return "OK!";
    }



}

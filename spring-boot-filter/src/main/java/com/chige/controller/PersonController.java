package com.chige.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping("/servlet")
    public String say(){
        System.out.println("...PersonController say()");
        return "Hello Servlet";
    }
}

package com.chige.controller;

import com.chige.bean.Soup;
import com.chige.config.SoupConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoupController {
    @Autowired
    private SoupConfig soupConfig;

    @RequestMapping("/soup")
    public Soup fanhuiSoup(){
        Soup soup = new Soup();
        soup.setOne(soupConfig.getOne());
        soup.setTwo(soupConfig.getTwo());
        soup.setThree(soupConfig.getThree());
        return soup;
    }

}

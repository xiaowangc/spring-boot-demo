package com.chige.es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyc
 * @date 2022/1/11
 */
@RestController
public class HealthController {

    @GetMapping("/health/test")
    public String healthTest() {
        return "OK!";
    }
}

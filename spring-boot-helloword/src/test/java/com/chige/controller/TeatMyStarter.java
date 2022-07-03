package com.chige.controller;

import com.chige.hellostarter.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangyc
 * @date 2022/7/3
 */
@SpringBootTest
public class TeatMyStarter {

    @Autowired
    private HelloService helloService;

    @Test
    public void testHello() {
        String s = helloService.sayHello();
        System.out.println(s);
    }

}

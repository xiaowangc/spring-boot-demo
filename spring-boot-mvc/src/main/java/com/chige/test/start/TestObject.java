package com.chige.test.start;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wangyc
 * @date 2022/6/12
 */
@Component
public class TestObject {

    static {
        System.out.println("static");
    }
    public TestObject() {
        System.out.println("构造方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("postConstruct");
    }



}

package com.chige.hellostarter.service.impl;

import com.chige.hellostarter.configuration.HelloProperties;
import com.chige.hellostarter.service.HelloService;

/**
 * @author wangyc
 * @date 2022/7/3
 */
public class HelloServiceImpl implements HelloService {

    private HelloProperties helloProperties;

    public HelloServiceImpl() {}

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello() {
        return helloProperties.getPrefix() + ":" + helloProperties.getSuffix();
    }
}

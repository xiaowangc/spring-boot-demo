package com.chige.hellostarter.configuration;

import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyc
 * @date 2023/10/14
 */
public class FactoryBeanOne implements InitializingBean {
    private Integer loadCount = 0;
    private List<Integer> list = null;

    public FactoryBeanOne() {
        System.out.println("构造FactoryBeanOne");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("工程bean初始化");
        init();
        loadCount++;
        System.out.println("加载次数为: " + loadCount);
    }

    public void init() {
        list = new ArrayList<>();
        list.add(1);
        list.add(10);
    }

}

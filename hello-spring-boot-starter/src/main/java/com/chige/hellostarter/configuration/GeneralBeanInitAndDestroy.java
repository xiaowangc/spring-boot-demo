package com.chige.hellostarter.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/** 普通bean的初始化和销毁
 * @author wangyc
 * @date 2023/10/14
 */
public class GeneralBeanInitAndDestroy {

    @PostConstruct
    public void init() {
        System.out.println("初始化bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁bean...");
    }

}

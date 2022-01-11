package com.chige.xxl.demo.constanst;

import org.junit.Test;

/**
 * @author wangyc
 * @date 2021/7/18
 */
public enum TestEnum {

    OUT_ABC("ABC");
    private String title;
    TestEnum(String title) { this.title = title; }

    public String getTitle() {
        return title;
    }

}

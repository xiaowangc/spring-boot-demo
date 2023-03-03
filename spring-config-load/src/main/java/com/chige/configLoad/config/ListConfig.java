package com.chige.configLoad.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Configuration
@ConfigurationProperties(prefix = "mylist")
public class ListConfig {

    private List<String> list = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private List<String> list3;
    public List<String> getList() {
        return list;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList2(List<String> list2) {
        this.list2 = list2;
    }

    public List<String> getList3() {
        return list3;
    }

    public void setList3(List<String> list3) {
        this.list3 = list3;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}

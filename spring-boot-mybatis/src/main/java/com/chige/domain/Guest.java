package com.chige.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
//添加全参构造方法


public class Guest implements Serializable {
    private String name;//姓名
    private String role;//角色
    private Integer userId;
    private Integer age;
    public Guest(){}
    public Guest(String name, String role){
        this.name = name;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

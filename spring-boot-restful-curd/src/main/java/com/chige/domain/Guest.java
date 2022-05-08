package com.chige.domain;

//添加全参构造方法

import lombok.ToString;

@ToString
public class Guest {
    private Integer userId;
    private String name;//姓名
    private String role;//角色

    public Guest(){}
    public Guest(String name,String role){
        this.name = name;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

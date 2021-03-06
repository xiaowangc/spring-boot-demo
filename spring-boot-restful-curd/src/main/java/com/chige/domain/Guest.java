package com.chige.domain;

import org.springframework.stereotype.Component;
//添加全参构造方法

@Component
public class Guest {
    private String name;//姓名
    private String role;//角色

    public Guest(){}
    public Guest(String name,String role){
        this.name = name;
        this.role = role;
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

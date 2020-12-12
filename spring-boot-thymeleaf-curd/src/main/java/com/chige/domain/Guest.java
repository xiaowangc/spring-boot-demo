package com.chige.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//添加全参构造方法

//@Component("SingletonBean")告诉Spring这是一个bean
@Component
//@Scope("prototype")
//@Scope("singleton")
//下面三个作用域，仅限于web中的spring WebApplicationContext环境下使用
//@Scope("request")，session，application
public class Guest  {
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

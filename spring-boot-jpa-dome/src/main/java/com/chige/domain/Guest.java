package com.chige.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
//添加全参构造方法

//@Component("SingletonBean")告诉Spring这是一个bean
@Entity
//@Scope("prototype")
//@Scope("singleton")
//下面三个作用域，仅限于web中的spring WebApplicationContext环境下使用
//@Scope("request")，session，application
@Data@AllArgsConstructor@NoArgsConstructor
public class Guest implements Serializable {
    @Id
    private Integer id;
    @Column
    private String name;//姓名
    @Column
    private String role;//角色



}

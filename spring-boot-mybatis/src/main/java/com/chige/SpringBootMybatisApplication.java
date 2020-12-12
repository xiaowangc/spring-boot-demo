package com.chige;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//MyBatis集成SpringBoot框架，使用MyBatis的方式之一：基于注解的形式
//步骤： 1.推荐在程序入口处使用MapperScan("mapper包路径"),扫描编写sql语句的所有类
//      2.创建相关查询数据库的类，即dao类，本例为com.chige.mapper.GuestMapper
//      3.在mapper文件中编写相应的类，如GuestMapper接口类
// 优点：不用在application.yml编写相关的mybatis-config.xml等文件，更加简单编辑
//      不用写相关的mapper文件，直接使用注解就行了   另外一个程序是编写mapper文件的示例-> spring-boot-mybatis-demo

//1.配置多数据源时，不要使用MapperScan注解了，在application.yml中配置多数据源
//2.新建一个config文件，创建一些读取application.yml的实体类

//注意：mybatis-plus与最新版本的spring-boot的多数据源兼容性不是很好
@SpringBootApplication
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}

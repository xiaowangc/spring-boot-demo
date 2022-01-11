package com.chige.openfeign.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean(name = "db1") //将DataSource这个类交给spring容器进行管理
    @ConfigurationProperties("spring.datasource.db1")//读取application.xml中 db1 下的内容，jdbc-url,username,password等信息
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

}

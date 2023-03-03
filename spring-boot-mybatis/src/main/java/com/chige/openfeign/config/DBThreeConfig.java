package com.chige.openfeign.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.chige.mapper3",sqlSessionFactoryRef = "sqlSessionFactory3",sqlSessionTemplateRef = "sessionTemplate3")
public class DBThreeConfig {

    //一般 Autowired注解是与Qualifier注解一起使用的
    @Autowired
    @Qualifier("db3")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory3() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sessionTemplate3() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory3());
        return template;
    }





}

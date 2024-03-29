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
@MapperScan(basePackages = "com.chige.mapper2",sqlSessionFactoryRef = "sqlSessionFactory2",sqlSessionTemplateRef = "sessionTemplate2")
public class DBTwoConfig {

    //一般 Autowired注解是与Qualifier注解一起使用的
    @Autowired
    @Qualifier("db2")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }





}

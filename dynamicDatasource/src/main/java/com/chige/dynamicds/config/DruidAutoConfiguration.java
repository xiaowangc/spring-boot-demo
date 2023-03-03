package com.chige.dynamicds.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.chige.dynamicds.ds.DynamicDataSource;
import com.chige.dynamicds.provider.DynamicDataSourceProvider;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author wangyc
 * @date 2023/3/2
 */
@Configuration
public class DruidAutoConfiguration {

    @Autowired
    DynamicDataSourceProvider dynamicDataSourceProvider;

    @Bean
    DynamicDataSource dynamicDataSource() {
        return new DynamicDataSource(dynamicDataSourceProvider);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.ds.three")
    public DataSource threeDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }

}

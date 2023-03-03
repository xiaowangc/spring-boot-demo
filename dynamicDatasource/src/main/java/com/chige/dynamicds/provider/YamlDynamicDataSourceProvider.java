package com.chige.dynamicds.provider;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.chige.dynamicds.config.DruidProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyc
 * @date 2023/3/2
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class YamlDynamicDataSourceProvider implements DynamicDataSourceProvider {
    Logger log = LoggerFactory.getLogger(YamlDynamicDataSourceProvider.class);
    @Autowired
    DruidProperties druidProperties;

    @Override
    public Map<String, DataSource> loadDataSources() {
        Map<String, DataSource> map = new HashMap<>(druidProperties.getDs().size());
        Map<String, Map<String, String>> dsMap = druidProperties.getDs();
        for (String s : dsMap.keySet()) {
            try {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(dsMap.get(s));
                map.put(s, druidProperties.dataSource(dataSource));
            } catch (Exception e) {
                log.error("创建数据源时异常，名称：{}, 原因:{}", s, e);
            }

        }
        return map;
    }
}

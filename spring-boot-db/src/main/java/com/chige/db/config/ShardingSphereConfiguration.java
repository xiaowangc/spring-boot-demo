package com.chige.db.config;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.infra.config.mode.PersistRepositoryConfiguration;
import org.apache.shardingsphere.mode.repository.standalone.StandalonePersistRepositoryConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;


/**
 * @author wangyc
 * @date 2023/11/2
 */
@ConfigurationProperties(prefix = "mode")
@Configuration
public class ShardingSphereConfiguration {
    private String type;
    private PersistRepositoryConfiguration repository;

    @Bean
    public DataSource dataSource() throws IOException, SQLException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(ResourceUtils.getFile("classpath:application.yml"));
        return dataSource;
    }

    @Bean
    public ModeConfiguration createModeConfig() {
        ModeConfiguration modeConfiguration = new ModeConfiguration(type, repository);
        return modeConfiguration;
    }




}

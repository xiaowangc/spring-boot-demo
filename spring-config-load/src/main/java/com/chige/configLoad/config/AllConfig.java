package com.chige.configLoad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Configuration
@EnableConfigurationProperties(value = {BasicConfig.class, ListConfig.class, MapConfig.class}) // 指定获取配置类的属性
public class AllConfig {

    public BasicConfig basicConfig;
    public ListConfig listConfig;
    public MapConfig mapConfig;

    public AllConfig() {
    }

//    @Autowired
    public AllConfig(BasicConfig basicConfig, ListConfig listConfig, MapConfig mapConfig) {
        this.basicConfig = basicConfig;
        this.listConfig = listConfig;
        this.mapConfig = mapConfig;
    }

    @Bean
    public Config loadConfig(BasicConfig basicConfig) {

        return new Config(basicConfig.getMaxVal(), basicConfig.getMinVal());
    }


    public class Config {

        private Integer maxVal;
        private Integer minVal;

        @Override
        public String toString() {
            return "Config{" +
                    "maxVal=" + maxVal +
                    ", minVal=" + minVal +
                    '}';
        }

        public Config(Integer maxVal, Integer minVal) {
            this.maxVal = maxVal;
            this.minVal = minVal;
        }

        public Integer getMaxVal() {
            return maxVal;
        }

        public void setMaxVal(Integer maxVal) {
            this.maxVal = maxVal;
        }

        public Integer getMinVal() {
            return minVal;
        }

        public void setMinVal(Integer minVal) {
            this.minVal = minVal;
        }
    }

}

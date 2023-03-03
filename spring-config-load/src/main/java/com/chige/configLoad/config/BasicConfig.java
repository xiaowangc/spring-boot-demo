package com.chige.configLoad.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Configuration
@ConfigurationProperties(prefix = "my.properties")
public class BasicConfig {
    private Integer maxVal;
    private Integer minVal;

    public void stdout() {
        System.out.println("maxVal=" + maxVal + ", minVal=" + minVal);
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

package com.chige.sdk.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangyc
 * @date 2023/10/16
 */
@ConfigurationProperties(prefix = "com.chige.sdk.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}

package com.chige.configLoad.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyc
 * @date 2023/3/3
 */
@Configuration
@ConfigurationProperties(prefix = "map1")
public class MapConfig {

    private Map<String, String> map = new HashMap<>();
    private Map<String, Map<String, String>> doubleMap = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, Map<String, String>> getDoubleMap() {
        return doubleMap;
    }

    public void setDoubleMap(Map<String, Map<String, String>> doubleMap) {
        this.doubleMap = doubleMap;
    }
}

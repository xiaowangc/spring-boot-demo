package com.chige.hellostarter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 读取配置文件的类
 * @author wangyc
 * @date 2022/7/3
 */
@ConfigurationProperties(prefix = "com.chige.hellostart.hello") //读取配置文件的注解
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return "HelloProperties{" +
                "prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}

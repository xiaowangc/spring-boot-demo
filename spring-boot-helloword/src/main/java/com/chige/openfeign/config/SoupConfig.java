package com.chige.openfeign.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "soup")
@PropertySource("classpath:application.yml")
public class SoupConfig {
    private String one;
    private String two;
    private String[] three;

    public String[] getThree() {
        return three;
    }

    public void setThree(String[] three) {
        this.three = three;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }
}

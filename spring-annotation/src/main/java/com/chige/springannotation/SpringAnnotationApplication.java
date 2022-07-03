package com.chige.springannotation;

import com.chige.springannotation.configuration.HelloProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(HelloProperties.class)
@ConfigurationPropertiesScan(basePackages = {"com.chige.springannotation.configuration"})
public class SpringAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotationApplication.class, args);
    }

}

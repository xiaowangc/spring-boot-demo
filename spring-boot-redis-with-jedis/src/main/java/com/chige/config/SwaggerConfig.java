package com.chige.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        log.info("加载swagger配置");
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chige"))
                .paths(PathSelectors.any())
                .build();
                //下面这个设置就是在接口的path前加上项目名
        return docket;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Redis高并发实战")
                .description("Redis高并发实战相关案例接口")
                .license("1.0")
                .termsOfServiceUrl("http://www.github/xiaowangc")
                .version("v1.0")
                .build();
    }




}

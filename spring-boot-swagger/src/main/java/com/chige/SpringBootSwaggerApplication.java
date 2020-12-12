package com.chige;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 编写swagger文档，首先需要引入两个依赖，再建立配置文件类config.SwaggerConfig.java ，
 * @EnableSwagger2 用来开启swagger功能
 *  @Api  @ApiOperation("xxx"), @ApiIgnore  @ApiImplicitParam(name = "name",value = "姓名")
 *  @ApiModel("嘉宾") @ApiModelProperty("姓名") 等等-->
 */
@SpringBootApplication
public class SpringBootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerApplication.class, args);
    }

}

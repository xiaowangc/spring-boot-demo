package com.chige;

import com.chige.openfeign.config.FoodConfig;
import com.chige.openfeign.config.SoupConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @SpringBootApplication
 * 声明入口类 并且声明时springboot项目
 */
@SpringBootApplication
@EnableConfigurationProperties({FoodConfig.class, SoupConfig.class})
public class DemoApplication {

    public static void main(String[] args) {

        /**有三种方式可以启动springboot项目：
         * 第一种启动springboot项目的方式:
         *      使用SpringApplication的静态类，启动springboot程序
         *  方法的参数：程序的入口类DemoApplication.class、 main函数的参数
         */
        SpringApplication.run(DemoApplication.class,args);
    }
}
/**
 * 第二种启动springboot项目的方式:
 *               -通过在pom.xml引入插件依赖的方式，点击spring-boot-run开启springboot程序
 * 第三种启动springboot项目的方式:
 *               -利用maven管理工具下Lifecycle下的package命令将整个项目打包成jar包，
 *                并在命令窗口通过java -jar jar包名启动springboot项目
 *
 *
 *
 *
 *
 *
 */


/**
 * 配置类相关注解的解释以及应用
 * - @Configuration //指定类是一个配置类
 * - @ConfigurationProperties(prefix="a") //加载满足前缀为a的配置
 * - @EnableConfigurationProperties({xx.class}) //加载指定的配置类进容器中
 * - @ConfigurationPropertiesScan(basePackages = {"com.chige.es.config"}) //扫描自定义包名下的配置类，并加载到容器中
 * - @EnableAutoConfiguration
 * - @SpringBootConfiguration
 * - @ManagementContextConfiguration
 * - @@PropertySource(value={"classpath:person.properties"})//指定读取person.properties配置文件
 */
package com.chige.springannotation.configuration;

/**
 * - @ConfigurationProperties 注解的几种使用方式：
 * 方式一：@Configuration + @ConfigurationProperties
 * 方式二：@ConfigurationProperties + @EnableConfigurationProperties(HelloProperties.class)
 * 方式三：@ConfigurationProperties + @ConfigurationPropertiesScan(basePackages = {"com.chige.springannotation.configuration"})
 * 方式四：@ConfigurationProperties + @Bean 这两个注解都作用在方法上，@Configuration作用在类上
 * 方式五：通过构造函数绑定的方式：@ConfigurationProperties + @ConstructorBinding 这两个注解都作用在配置类上（配置类需要定义全参构造函数），
 *        然后使用@EnableConfigurationProperties注解显示配置类
 */
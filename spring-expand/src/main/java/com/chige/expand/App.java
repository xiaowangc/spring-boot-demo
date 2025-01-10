package com.chige.expand;

import com.chige.expand.initializer.EnvironmentInitializer;
import com.chige.expand.initializer.PropertySourceInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2025/1/8 22:48
 */
@SpringBootApplication
public class App {

    @Value("${user.dir}")
    private String userDir;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(App.class);
        application.addInitializers(new PropertySourceInitializer());
        application.run(args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Environment environment = applicationContext.getEnvironment();

    }
}

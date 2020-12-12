package com.chige.customizer;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/** 错误页方式四：使用WebServerFactoryCustomizer来注册Bean,通过更改错误码的处理路径，来指定不同的页面
 *
 */
@Configuration
public class MyCustomizer {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> customizer(){
        return factory -> factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error404"));
    }
}

package com.chige;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 本例题包含了
 *    1.数据验证方式（@NotBlank @NotNull @NotEmpty @Valid BindingResult）
 *   2. 错误页定义的四种方式 :
 *                  方式一：public/error/404.html                   (优先级最低)
 *                  方式二：templates/error/404.html
 *                  方式三：错误视图解析器 resolver/MyErrorViewResolver
 *                  方式四：WebServerFactoryCustomizer              （优先级最高）
 *   3.全局异常处理
 */
@SpringBootApplication
public class SpringBootErrorExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootErrorExceptionApplication.class, args);
    }

}

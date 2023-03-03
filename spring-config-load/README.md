*配置加载*
1、使用SpringBoot注解加载配置
@ConfigurationProperties(prefix = "my.properties")
此注解可读取配置文件中指定前缀的配置，配合类中属性名称可加载；
如application.yml中 `my.properties.name`,则属性为 `private String name`可读取到配置。


2、使用Spring提供的注解加载配置
@Value("${my.properties.name}") 此注解也可读取到对应的配置。


3、读取配置框架的配置
4、命令行配合IDEA的方式配置相关属性并加载

配置加载的优先级：


@EnableConfigurationProperties({MyConfig.class})
可以在某个类上引用该注解，获取指定类的配置。`具体例子如AllConfig类`

### 配置文件中的属性占位符
${spring.name}
${random.int}

### Mybatis框架的配置加载


Spring容器启动时自动加载代码的几种方式：
静态块、构造方法、@PostConstruct、实现ApplicationRunner、实现CommandLineRunner接口

1、java自身启动时加载代码的方式：
静态块、构造方法

2、Spring中启动时加载代码的方式：
(1)@PostConstruct: 使用在方法上，这个方法在对象依赖注入初始化之后执行
(2)实现ApplicationRunner接口: Spring容器启动完成后执行的功能
(3)实现CommandLineRunner接口: Spring容器启动完成后执行的功能

3、@Order注解
当多个类实现了ApplicationRunner和CommandLineRunner接口时，可以通过在类上添加@Order注解来设定运行顺序。

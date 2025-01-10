## 实现SpringBoot 添加扩展点：
1. 在启动类中用springApplication.addInitializers(new TestApplicationContextInitializer())语句加入
2. 在application.yml配置文件中添加： context.initializer.classes = xxx.customerInitializer
3. 利用SpringSPI扩展，在spring.factories中加入：
com.chige.expand.initializer.PropertySourceInitializer


### BeanFactoryPostProcessor
```beanFactory的扩展接口```
1. 调用时机: 在spring在读取beanDefinition信息之后，实例化bean之前
2. 修改 Bean 的定义元数据，例如Scope、依赖查找方式、初始化方法、修改属性值、添加额外的元数据等，进而影响初始化行为。
注意：自定义实现`BeanFactoryPostProcessor`接口时，不要在这里做Bean的实例化


### BeanDefinitionRegistryPostProcessor
定位：容器级后置处理器
作用：在Spring容器初始化后、刷新前执行一次，用于动态注册Bean到容器
父类接口：BeanFactoryPostProcessor



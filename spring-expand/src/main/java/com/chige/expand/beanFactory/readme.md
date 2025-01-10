## BeanFactoryPostProcessor

调用时机：在读取BeanDefinition之后，bean实例化之前
此时无法定义注册beanDefinition，但是可以获取并修改

作用：修改 Bean 的定义元数据，例如Scope、依赖查找方式、初始化方法、修改属性值、添加额外的元数据等，
     进而影响初始化行为
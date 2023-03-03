package com.chige.dynamicds.annotation;

import java.lang.annotation.*;

/**
 * @author wangyc
 * @date 2023/3/2
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

  String dataSourceName() default "";

}

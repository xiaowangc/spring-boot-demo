package com.chige.sdk.door.annotation;

import java.lang.annotation.*;

/**
 * @author wangyc
 * @date 2023/10/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface DoDoor {

    String key() default "";

    String returnJson() default "";

}

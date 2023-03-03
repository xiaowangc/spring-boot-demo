package com.chige.dynamicds.aop;

import com.chige.dynamicds.annotation.DataSource;
import com.chige.dynamicds.config.DruidProperties;
import com.chige.dynamicds.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author wangyc
 * @date 2023/3/2
 */
@Order(1)
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.chige.dynamicds.annotation.DataSource)"
            + "|| @within(com.chige.dynamicds.annotation.DataSource)")
    public void dsPc() {
    }

    @Around("dsPc()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource dataSource = getDataSource(point);
        if (Objects.nonNull(dataSource)) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.dataSourceName());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    private DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource annotation = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (Objects.nonNull(annotation)) {
            return annotation;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }


}

package com.xhe.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author xhe
 * @date 2018年4月28日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}

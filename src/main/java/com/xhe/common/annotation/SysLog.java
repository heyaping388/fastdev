package com.xhe.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * 
 * @author xhe
 * @date 2018年4月28日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}

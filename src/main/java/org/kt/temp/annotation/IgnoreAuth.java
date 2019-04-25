package org.kt.temp.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义注解，忽略登录验证
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface IgnoreAuth {
}

package com.springboot.core.jdbc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:17
 * @Package: com.springboot.core.jdbc.annotation
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Columns {
    String column() default "";

    boolean primaryKey() default false;

    boolean autoIncrement() default true;

}

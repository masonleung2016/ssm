package com.springboot.core.security.requestlimt;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:47
 * @Package: com.springboot.core.security.requestlimt
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface RequestLimit {

    int time() default 60;

    int count() default 50;

    int waits() default 300;

}

package com.fuwenhao.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/5/20 10:57 上午
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    /**
     * 地址
     *
     * @return
     */
    String address();

    /**
     * 年龄
     *
     * @return
     */
    int age();
}

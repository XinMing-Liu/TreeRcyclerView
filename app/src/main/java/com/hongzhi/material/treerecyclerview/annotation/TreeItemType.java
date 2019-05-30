package com.hongzhi.material.treerecyclerview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用在item的类上
 *
 * @Author XinMing-Liu
 * @create 2019/5/29 8:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface TreeItemType {
    int type() default -1;
}

package com.hongzhi.treerecyclerviewlib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 8:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TreeDataType {
    /**
     * 直接绑定 itemclass
     *
     * @return
     */
    Class iClass() default Object.class;

    /**
     * @return
     */
    int value() default -1;
}

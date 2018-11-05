package com.syuka.utils;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //接口、类、枚举、注解
//@Target({ElementType.METHOD})//
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface LogAnnotation {

    /**
     * 行为描述，数据类型为String类型
     * @return
     */
    String value() default "";
}

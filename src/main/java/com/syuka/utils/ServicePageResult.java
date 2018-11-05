package com.syuka.utils;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Target({ElementType.METHOD}) //接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface ServicePageResult {

  boolean value() default true;
}

package com.syuka.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_1102
 * @description: 自定义注解实现类
 * @author: Qinxiuhua
 * @create: 2018-11-05 15:07
 **/

@Aspect
@Component
public class LogAnnotationAnalytic {

    @Before("execution(* com.syuka.controller..*.*(..)) && @annotation(logAnnotation)")
    public void logAnnotation(final JoinPoint joinPoint, LogAnnotation logAnnotation ) {
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("--------------------------"+logAnnotation.value()+"注解成功--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

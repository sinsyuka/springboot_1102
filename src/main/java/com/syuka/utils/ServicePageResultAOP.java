package com.syuka.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.*;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: springboot_1102
 * @description: service分页注解
 * @author: Qinxiuhua
 * @create: 2018-11-05 16:44
 **/

@Aspect
@Component
public class ServicePageResultAOP {

    @Pointcut(value = "execution(* com.syuka.service..*.*(..))")
    public void managerLogPoint() {
    }

    @Around("managerLogPoint()")
    public Object aroundManagerLogPoint(ProceedingJoinPoint jp) throws Throwable {
        Class target = jp.getTarget().getClass();
        ServicePageResult result = (ServicePageResult) target.getAnnotation(ServicePageResult.class);
        if(Objects.isNull(result)){
            jp.proceed();
        }else {
            for (Method method :target.getMethods()) {
                if(!Objects.isNull(method.getAnnotation(ServicePageResult.class))){
                    method.
                }

            }
        }
        return jp.proceed();
    }

}

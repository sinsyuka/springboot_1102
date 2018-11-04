package com.syuka.global_exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *  @ControllerAdvice 是 controller 的一个辅助类，最常用的就是作为全局异常处理的切面类
 *  可以指定扫描范围
 *  约定了几种可行的返回值，如果是直接返回 model 类的话，需要使用
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){

        Map<String,Object> map = new HashMap<>();

        map.put("code","500");
        map.put("message",e.getMessage());

        return map;

    }
}

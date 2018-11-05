package com.syuka.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syuka.model.Department;
import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.*;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;

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

    /**
     * @Around是可以同时在所拦截方法的前后执行一段逻辑
     */
    @Around("managerLogPoint()")
    public Object aroundManagerLogPoint(ProceedingJoinPoint jp) throws Throwable {
        Class target = jp.getTarget().getClass();
        Object[] args = jp.getArgs();
        //获取类名
        String clazzName = jp.getTarget().getClass().getName();
        //获取方法名称
        String methodName = jp.getSignature().getName();
        //通过反射获取参数列表
        Map<String,Object > nameAndArgs = this.getFieldsName(this.getClass(), clazzName, methodName,args);
    for (Method method :target.getDeclaredMethods()) {
        if(!Objects.isNull(method.getAnnotation(ServicePageResult.class))){
            // 开启分页插件,放在查询语句上面
            PageHelper.startPage(((Integer) nameAndArgs.get("pageNum")),(Integer)nameAndArgs.get("pageSize"));
            jp.proceed();

            // 封装分页之后的数据
            PageInfo<Department> pageInfoDepartment = new PageInfo<Department>((List<Department>) jp.proceed());
            return pageInfoDepartment;
        }

    }
        return jp.proceed();
    }
    /**
     * 通过反射获取参数列表
     * @throws Exception
     */
    private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws Exception {
        Map<String,Object > map=new HashMap<String,Object>();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++){
            map.put( attr.variableName(i + pos),args[i]);
        }
        return map;
    }

}

package com.demo.springbootlearningmcdull.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Arrays;

/**
 * 启动应用后，在
 * @Configuration 声明这是一个Spring容器管理配置Bean，这里是引起Spring的注意？
 * @Aspect 声明这是一个切面类
 * @Around 声明了一个表达式，描述要织入的目标的特性。如@within表示目标类型带有注解，其注解类型参数为org.springframework.stereotype.Controller，这意味着Spring Controller方法被调用的时候，都会执行@Around注解的方法，也就是simpleAOP
 *
 */
@Configurable
@Aspect
public class AOPConfig {
    /**
     * simpleAOP 是用来织入的代码，其参数为ProceedingJoinPoint 。
     * 本例中织入得代码做的事情是，把调用的方法的参数打印到控制台
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAOP(final ProceedingJoinPoint pjp) throws Throwable{
        try{
            Object[] args = pjp.getArgs();
            System.out.println("args:" + Arrays.asList(args));
            //通常情况下，执行完切面的代码之后，还需要继续执行应用代码，
            //proceed()方法会调用原来的方法，并将返回的对象正常返回
            Object o = pjp.proceed();
            System.out.println("return : " + o);
            return o;
        }catch (Throwable e){
            //如果原有的方法中执行时抛出了异常，在切面里不会处理这个异常，直接抛出给调用者
            throw e;
        }
    }
}

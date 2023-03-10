package com.example.aop.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    /*@Before("execution(public void com.example.aop.pointcut.UniLibrary.getBook())")*/
    // if we add class - it will work only for this class
   /* @Before("execution( public void get*())") // it will work for method with this prototype and name starts with get____
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice getBook");
    }

    @Before("execution( public void return*())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice getBook");
    }

    @Pointcut("execution( public void find*(String))") // args works like this
    public void beforeFindBookAdvice(){
        System.out.println("beforeFindBookAdvice getBook");
    }*/

    @Pointcut("execution(public void get*(*))")
    public void allGetMethods(){}

    @Pointcut("execution(public void *(*))")
    public void methodAdvice(){}

    @Before ("execution( public void get*(String))")
    public void beforeGetLoggingAdvice(){
        System.out.println("Logging advice");
    }

    @Before ("execution(public void find*(String)) || execution(public void return*(String))")
    public void beforeGetSecurityAdvice(){
        System.out.println("Security advice");
    }

    @Before("allGetMethods()")
    public void beforeAllGetMethods(){
        System.out.println("Using get methods");
    }

    @Before("methodAdvice()")
    public void allMethods(JoinPoint joinPoint){
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        System.out.println("    LOG: " + sign.getMethod() + "\n" +  "RETURN TYPE: " + sign.getReturnType());
        // also throug the Object[] args we can get all arguments id they be
    }
    @AfterReturning("execution(public Book return*(String, String))")
    public void returningAdvice(JoinPoint joinPoint){
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        System.out.println("RETURNING ADVICE ->  LOG: " + sign.getMethod() + "\n" +  "RETURN TYPE: " + sign.getReturnType());
    }
    /*The same pointcuts could be signed as
    * @Pointcut("execution(prototype)")
    * public void methodName(Arguments name){}
    *
    * and after you can just use name of pointcut like template
    *
    * also you can add 2 or more pointcut in @Before ad use && || ! for making logic
    * */
}

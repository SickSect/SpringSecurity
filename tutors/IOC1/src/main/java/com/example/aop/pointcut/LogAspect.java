package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    /*@Before("execution(public void com.example.aop.pointcut.UniLibrary.getBook())")*/
    // if we add class - it will work only for this class
    @Before("execution( public void get*())") // it will work for method with this prototype and name starts with get____
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice getBook");
    }

    @Before("execution( public void return*())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice getBook");
    }

    @Before("execution( public void find*(String))") // args works like this
    public void beforeFindBookAdvice(){
        System.out.println("beforeFindBookAdvice getBook");
    }
}

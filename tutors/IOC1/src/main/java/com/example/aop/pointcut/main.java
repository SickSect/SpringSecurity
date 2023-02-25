package com.example.aop.pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        UniLibrary libre = context.getBean("uni", UniLibrary.class);
        libre.getBook();
        SchoolLibrary libre_a = context.getBean("school", SchoolLibrary.class);
        libre_a.getBook();
        libre.findBook("Zoology");
        libre.returnBook();
        libre_a.returnBook();
        context.close();
    }
}

package com.example.aop.pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        UniLibrary libre = context.getBean("uni", UniLibrary.class);
        libre.getBook("Programming");
        SchoolLibrary libre_a = context.getBean("school", SchoolLibrary.class);
        libre_a.getBook("Zoology");
        libre.findBook("Zoology");
        libre.returnBook("Zoology");
        libre_a.returnBook( "Programming");
        context.close();
    }
}

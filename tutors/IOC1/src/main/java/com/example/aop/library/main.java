package com.example.aop.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        Library libre = context.getBean("library", Library.class);
        libre.getBook();
        context.close();
    }
}

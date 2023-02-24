package com.example.ioc1.property_source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main10 {
    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        Fruit fruit = context.getBean("fruit", Fruit.class);
        System.out.println(fruit.getName());
        context.close();
    }
}

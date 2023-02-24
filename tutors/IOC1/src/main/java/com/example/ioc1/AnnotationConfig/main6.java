package com.example.ioc1.AnnotationConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main6 {

    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextScan.xml");
        Item i = context.getBean("itemBean", Item.class);
        i.setName("Item class name!!!");
        System.out.println(i.getName() + " LOOK HERE");
        context.close();
    }
}

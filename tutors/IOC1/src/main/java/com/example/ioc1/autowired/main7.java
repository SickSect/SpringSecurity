package com.example.ioc1.autowired;

import com.example.ioc1.AnnotationConfig.Item;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main7 {

    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextScan.xml");
        Basic b = context.getBean("basicBean", Basic.class);
        b.setName("Basic name");
        Lead a = context.getBean("leadBean", Lead.class);
        System.out.println("1 " + b.getName() + " 2 " + a.getB().getName() + " lead");
        context.close();
    }
}

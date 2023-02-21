package com.example.ioc1.BeanScope;

import com.example.ioc1.step3.Author;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main4 {
    public static void main(String[]args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Door a = context.getBean("door", Door.class);
        Door b = context.getBean("door", Door.class);
        System.out.println("SINGLETONE bean : " + (a == b) + "\nADDR: " + a +" | "+ b);
        context.close();
    }
}

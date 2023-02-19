package com.example.ioc1.step2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main2 {
    public static void main(String[]args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student s = context.getBean("student", Student.class);
        s.showBook();
    }
}

package com.example.ioc1.value;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main9 {

    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextScan.xml");
        Person person = context.getBean("persona", Person.class);
        person.callYourPet();
        person.callName();
        context.close();
    }
}

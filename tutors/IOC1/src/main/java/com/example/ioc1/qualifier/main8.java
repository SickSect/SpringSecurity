package com.example.ioc1.qualifier;

import com.example.ioc1.AnnotationConfig.Item;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main8 {
    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextScan.xml");
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        context.close();
    }
}

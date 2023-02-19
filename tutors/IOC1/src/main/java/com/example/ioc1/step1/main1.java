package com.example.ioc1.step1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main1 {

    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Owner owner = context.getBean("owner", Owner.class);
        // no need to add pet, bc alredy add the bean with item.class
        owner.showItem();
    }
}

package com.example.ioc1.InitAndDestroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main5 {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_1.xml");
        Phone p = context.getBean("phone", Phone.class);
        p.setFirm("apple");
        System.out.println(p.getFirm() + " FIRM");
        context.close();
        // but if you use scope prototype destroy method will not be called
        //do it by you self and free memory by your self
    }
}

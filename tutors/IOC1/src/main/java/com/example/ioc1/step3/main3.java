package com.example.ioc1.step3;

import com.example.ioc1.step2.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main3 {
    public static void main(String[]args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Author author = context.getBean("author", Author.class);
        author.info();
    }
}

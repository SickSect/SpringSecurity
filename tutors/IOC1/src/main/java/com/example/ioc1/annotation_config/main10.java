package com.example.ioc1.annotation_config;

import com.example.ioc1.step2.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main10 {
    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        Tree tree = context.getBean("tree", Tree.class);
        System.out.println(tree.getName());
        context.close();
    }
}

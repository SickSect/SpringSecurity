package com.example.aop.pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[]args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
       /* UniLibrary libre = context.getBean("uni", UniLibrary.class);
        libre.getBook("Programming");
        SchoolLibrary libre_a = context.getBean("school", SchoolLibrary.class);
        libre_a.getBook("Zoology");
        libre.findBook("Zoology");
        libre.returnBook("Zoology");
        libre_a.returnBook( "Programming");*/
        UniLibrary libre = context.getBean("uni", UniLibrary.class);
        SchoolLibrary libre_a = context.getBean("school", SchoolLibrary.class);
        libre.getSilence();
        libre.getBook("Picnic on the ned of the road");
        libre_a.getBook("Alpinist");
        libre.returnBook("Picnic on the end of the road", "Boris and Arcadiy Strugatsky");
        libre_a.returnBook("Alpinist", "B.Akunin");
        libre.getSilence();
        context.close();
    }
}

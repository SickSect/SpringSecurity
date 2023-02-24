package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("school")
public class SchoolLibrary extends AbstractLibrary{
    @Override
    public void getBook() {
        System.out.println("Take book from School library.");
    }
}

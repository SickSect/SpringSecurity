package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("school")
public class SchoolLibrary extends AbstractLibrary{
    @Override
    public void getBook(String name) {
        System.out.println("Take book " + name + " from School library.");
    }

    @Override
    public void returnBook(String name) {
        System.out.println("Return book " + name + " from School library.");
    }

    @Override
    public void findBook(String name) {
        System.out.println("Looking for book " + name + " from School library.");
    }
}

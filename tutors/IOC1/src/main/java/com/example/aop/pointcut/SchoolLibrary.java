package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("school")
public class SchoolLibrary extends AbstractLibrary{
    @Override
    public void getBook() {
        System.out.println("Take book from School library.");
    }

    @Override
    public void returnBook() {
        System.out.println("Return book from School library.");
    }

    @Override
    public void findBook(String name) {
        System.out.println("Looking for book " + name + " from School library.");
    }
}

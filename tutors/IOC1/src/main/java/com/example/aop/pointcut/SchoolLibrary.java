package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("school")
public class SchoolLibrary extends AbstractLibrary{
    @Override
    public void getBook(String name) {
        System.out.println("Take book " + name + " from School library.");
    }

    @Override
    public Book returnBook(String name,String author) {
        System.out.println("Return book " + name + " from School library.");
        return new Book();
    }

    @Override
    public void findBook(String name) {
        System.out.println("Looking for book " + name + " from School library.");
    }

    @Override
    void getSilence() {
        System.out.println("- you hear nothing -");
    }

    @Override
    void findDocument(String name) {
        System.out.println("Looking for info about " + name);
    }
}

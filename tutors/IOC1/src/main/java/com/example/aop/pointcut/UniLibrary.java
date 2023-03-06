package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("uni")
public class UniLibrary extends AbstractLibrary{

    @Override
    public void getBook(String name){
        System.out.println("Take book " + name + " from Unilibrary.");
    }

    @Override
    public Book returnBook(String name,String author) {
        System.out.println("Return book " + name + " from Uni library.");
        return new Book(name, author);
    }

    @Override
    public void findBook(String name) {
        System.out.println("Looking for book " + name + " from Uni library.");
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

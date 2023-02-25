package com.example.aop.pointcut;

import org.springframework.stereotype.Component;

@Component("uni")
public class UniLibrary extends AbstractLibrary{

    @Override
    public void getBook(){
        System.out.println("Take book from Unilibrary.");
    }

    @Override
    public void returnBook() {
        System.out.println("Return book from Uni library.");
    }

    @Override
    public void findBook(String name) {
        System.out.println("Looking for book " + name + " from Uni library.");
    }
}

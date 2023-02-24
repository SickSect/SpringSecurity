package com.example.aop.library;

import org.springframework.stereotype.Component;

@Component
public class Library {

    public void getBook(){
        System.out.println("Take book.");
    }
}

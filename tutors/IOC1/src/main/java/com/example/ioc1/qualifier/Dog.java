package com.example.ioc1.qualifier;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet {
    @Override
    public void makeSound() {
        System.out.println("BARK");
    }
}

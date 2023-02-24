package com.example.ioc1.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet {
    @Override
    public void makeSound() {
        System.out.println("MEOW");
    }
}

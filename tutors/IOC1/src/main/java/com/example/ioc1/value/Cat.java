package com.example.ioc1.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Barsik")
public class Cat implements Pet {
    @Value("Barsik")
    private String name;
    @Override
    public void makeSound() {
        System.out.println("MEOW");
    }

    @Override
    public void printName() {
        System.out.println(name);
    }
}

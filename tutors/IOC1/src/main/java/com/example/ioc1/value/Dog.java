package com.example.ioc1.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Richard")
public class Dog implements Pet {
    @Value("Richard")
    private String name;
    @Override
    public void makeSound() {
        System.out.println("BARK");
    }
    @Override
    public void printName() {
        System.out.println(name);
    }
}

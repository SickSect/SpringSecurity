package com.example.ioc1.entity;

public class Dog implements Pet{
    @Override
    public void makeSound() {
        System.out.println("BARK");
    }
}

package com.example.ioc1.entity;

public class Cat implements Pet{
    @Override
    public void makeSound() {
        System.out.println("MEOW");
    }
}

package com.example.ioc1.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("persona")
public class Person {
    private Pet pet;

    @Autowired
    public Person(@Qualifier("Barsik") Pet pet) {
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hey!");
        pet.makeSound();
    }

    public void callName(){
        pet.printName();
    }
}

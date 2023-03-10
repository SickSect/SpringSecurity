package com.example.ioc1.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;

    @Autowired
    public Person(@Qualifier("dogBean") Pet pet) {
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hey!");
        pet.makeSound();
    }
}

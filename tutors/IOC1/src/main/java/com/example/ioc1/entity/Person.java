package com.example.ioc1.entity;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hey!");
        pet.makeSound();
    }
}

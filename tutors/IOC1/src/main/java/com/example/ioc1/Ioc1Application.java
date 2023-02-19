package com.example.ioc1;

import com.example.ioc1.entity.Dog;
import com.example.ioc1.entity.Person;
import com.example.ioc1.entity.Pet;
import com.example.ioc1.step1.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

@SpringBootApplication
public class Ioc1Application {

	public static void main(String[] args) {
		/*1*//*
		Pet pet = new Dog();
		pet.makeSound();

		*//*2*//*
		// for using beans from file - you should create object from this class and using it to get beans
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Pet petA = context.getBean("PetCat", Pet.class);
		petA.makeSound();
		context.close(); // CLOSE IT

		*//*3*//*
		Person person = new Person(pet);
		person.callYourPet();
		ClassPathXmlApplicationContext context_a = new ClassPathXmlApplicationContext("applicationContext.xml");
		person = new Person(context_a.getBean("PetCat", Pet.class));
		person.callYourPet();
		//SpringApplication.run(Ioc1Application.class, args);*/


	}

}

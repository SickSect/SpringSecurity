package com.example.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Surname;
    private String mail;

    public Employee(String name, String surname, String mail) {
        this.name = name;
        Surname = surname;
        this.mail = mail;
    }

    public Employee() {

    }
}

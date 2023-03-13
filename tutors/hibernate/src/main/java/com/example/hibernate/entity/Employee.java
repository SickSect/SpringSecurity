package com.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Surname;
    private String mail;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn()
    private EmployeeRank rank;

    public Employee(String name, String surname, String mail) {
        this.name = name;
        Surname = surname;
        this.mail = mail;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

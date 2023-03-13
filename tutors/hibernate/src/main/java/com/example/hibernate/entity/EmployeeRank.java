package com.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
public class EmployeeRank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double Salary;
    private String rank;
    private String workplace;
    @OneToOne(mappedBy = "rank")
    private Employee employee;
}

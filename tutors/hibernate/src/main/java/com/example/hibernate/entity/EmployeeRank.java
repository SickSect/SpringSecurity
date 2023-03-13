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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rank")
    private Employee employee;

    public EmployeeRank(Double salary, String rank, String workplace, Employee employee) {
        Salary = salary;
        this.rank = rank;
        this.workplace = workplace;
        //this.employee = employee;
    }

    public EmployeeRank() {
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

}

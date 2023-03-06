package com.example.hibernate;

import com.example.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class HibernateApplication {

    public static void main(String [] args){
        //SpringApplication.run(App.class, args);
        // need to create sessions
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = sf.getCurrentSession();
            Employee emp = new Employee("Alex", "Durdon", "soap@mail.com");
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();
        }
        finally {
            sf.close();
        }
    }

}

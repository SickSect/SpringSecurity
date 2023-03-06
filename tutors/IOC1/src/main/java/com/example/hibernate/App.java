package com.example.hibernate;

import com.example.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class App {
    public static void main(String [] args){
        //SpringApplication.run(App.class, args);
        // need to create sessions
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
       /*     //Session factory reads hibernate.yml
        Session session = sf.getCurrentSession();
            // session is inner class that can connect to DB
        Employee emp = new Employee("Alex", "Durdon", "soap@mail.com");
        session.beginTransaction();
            // start working with DB
        session.persist(emp);
            //save is deprecated so we use persist
        session.getTransaction().commit();
            //agree our updates and commit
        sf.close();*/
            //we need to close it
            // but better to use try catch
        try {
            Session session = sf.getCurrentSession();
            Employee emp = new Employee("Alex", "Durdon", "soap@mail.com");
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            sf.close();
        }
    }
}

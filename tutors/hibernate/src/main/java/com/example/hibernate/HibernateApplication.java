package com.example.hibernate;

import com.example.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {

    public static void main(String [] args){
        //SpringApplication.run(App.class, args);
        // need to create sessions
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            // create new and save
            Session session = sf.getCurrentSession();
            /*Employee emp = new Employee("Porter", "Mordur", "perl@mail.com");
            Employee emp1 = new Employee("Mortan", "Voland", "voda@mail.com");
            Employee emp2 = new Employee("Anter", "Loper", "beach@mail.com");
            session.beginTransaction();
            session.persist(emp);
            session.persist(emp1);
            session.persist(emp2);*/
            //session.getTransaction().commit();
            //get from DB
            //session.getTransaction().commit();
            /*session.beginTransaction();
            System.out.println(session.get(Employee.class, 1).getName() + " ! " + session.get(Employee.class, 2).getName() + " ! " + session.get(Employee.class, 3).getName());
            session.getTransaction().commit();*/
            //update obj from db
            /*session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            emp.setMail("DUMB@soap.org");
            System.out.println(session.get(Employee.class, 1).getMail() + " ! " + session.get(Employee.class, 2).getName() + " ! " + session.get(Employee.class, 3).getName());
            session.getTransaction().commit();*/
        }
        finally {
            sf.close();
        }
    }

}

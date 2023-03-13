package com.example.hibernate;

import com.example.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    public static void main(String [] args){
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = sf.getCurrentSession();

        }
        finally {
            sf.close();
        }
    }
}

package com.example.hibernate;

import com.example.hibernate.entity.Employee;
import com.example.hibernate.entity.EmployeeRank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    public static void main(String [] args){
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sf.getCurrentSession();
        try {

            session.beginTransaction();
            /*Employee emp = new Employee("Alyx" , "Login", "api@mail.com");
            Employee emp1 = new Employee("Merlin" , "White", "magic@mail.com");
            Employee emp2 = new Employee("Parsiphal" , "Third", "graal@mail.com");
            EmployeeRank rank = new EmployeeRank(1200.99, "tester", "office", emp);
            EmployeeRank rank1 = new EmployeeRank(3100.59, "tester", "office", emp1);
            EmployeeRank rank2 = new EmployeeRank(2300.19, "tester", "office", emp2);
            session.beginTransaction();
            session.persist(emp);
            session.persist(emp1);
            session.persist(emp2);*/
            //session.getTransaction().commit();
        }
        finally {
            session.close();
            sf.close();

        }
    }
}

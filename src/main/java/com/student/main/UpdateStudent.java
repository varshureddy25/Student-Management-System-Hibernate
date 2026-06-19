package com.student.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.student.entity.Student;

public class UpdateStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, 101);

        if (s != null) {
            s.setName("Varshitha Reddy");
            s.setEmail("varshithareddy@gmail.com");

            session.update(s);
            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }

        tx.commit();
        session.close();
        factory.close();
    }
}
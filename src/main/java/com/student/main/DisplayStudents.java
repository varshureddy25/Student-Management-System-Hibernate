package com.student.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.entity.Student;

public class DisplayStudents {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Student> students =
                session.createQuery("from Student", Student.class).list();

        for(Student s : students) {
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("Department: " + s.getDepartment());
            System.out.println("Email: " + s.getEmail());
            System.out.println("-------------------");
        }

        session.close();
        factory.close();
    }
}
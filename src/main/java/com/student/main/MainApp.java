package com.student.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.student.entity.Student;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            switch (choice) {

            case 1:
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                Student s = new Student(id, name, dept, email);

                session.save(s);
                tx.commit();

                System.out.println("Student Inserted Successfully!");
                break;

            case 2:
                List<Student> students =
                        session.createQuery("from Student", Student.class).list();

                System.out.println("\n--- Student Records ---");

                for (Student st : students) {
                    System.out.println("ID: " + st.getId());
                    System.out.println("Name: " + st.getName());
                    System.out.println("Department: " + st.getDepartment());
                    System.out.println("Email: " + st.getEmail());
                    System.out.println("-----------------------");
                }
                break;

            case 3:
                System.out.print("Enter Student ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Student updateStudent =
                        session.get(Student.class, updateId);

                if (updateStudent != null) {

                    System.out.print("Enter New Name: ");
                    updateStudent.setName(sc.nextLine());

                    System.out.print("Enter New Department: ");
                    updateStudent.setDepartment(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    updateStudent.setEmail(sc.nextLine());

                    session.update(updateStudent);
                    tx.commit();

                    System.out.println("Student Updated Successfully!");
                } else {
                    System.out.println("Student Not Found!");
                }
                break;

            case 4:
                System.out.print("Enter Student ID to Delete: ");
                int deleteId = sc.nextInt();

                Student deleteStudent =
                        session.get(Student.class, deleteId);

                if (deleteStudent != null) {

                    session.delete(deleteStudent);
                    tx.commit();

                    System.out.println("Student Deleted Successfully!");
                } else {
                    System.out.println("Student Not Found!");
                }
                break;

            case 5:
                session.close();
                factory.close();
                sc.close();

                System.out.println("Application Closed.");
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
            }

            session.close();
        }
    }
}
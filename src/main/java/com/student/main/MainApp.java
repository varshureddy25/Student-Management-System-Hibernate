
		package com.student.main;

		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;

		import com.student.entity.Student;

		public class MainApp {

		    public static void main(String[] args) {

		        Configuration cfg = new Configuration();
		        cfg.configure("hibernate.cfg.xml");

		        SessionFactory factory = cfg.buildSessionFactory();

		        Session session = factory.openSession();

		        Transaction tx = session.beginTransaction();

		        Student s = new Student(
		                101,
		                "Varshitha",
		                "CSE",
		                "varshitha@gmail.com"
		        );

		        session.save(s);

		        tx.commit();

		        System.out.println("Student Record Inserted Successfully!");

		        session.close();
		        factory.close();
		    }
		}
	



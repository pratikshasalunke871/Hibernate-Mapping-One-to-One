package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Student;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Laptop l = new Laptop();
		l.setL_id(1200);
		l.setL_name("hp");
		ss.persist(l);

		Student s = new Student();
		s.setS_id(1);
		s.setS_name("Pratiksha");
		s.setLaptop(l);

		ss.persist(s);

		System.out.println("Data Mapping successfully");

		tr.commit();
		ss.close();
	}

}



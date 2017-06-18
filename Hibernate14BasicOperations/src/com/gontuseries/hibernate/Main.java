package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setStudent_name("AESHWER");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(student1);
		
		try{
		student1 = (Student)session.get(Student.class, 1); //2nd argument is the primary key
		System.out.println("Student object having suden name is " + student1.getStudent_name());
		}catch(Exception e)
		{System.out.println(e);}
		
		//for update
		student1.setStudent_name("KANIKA");
		session.update(student1);
		
		//delete operation .. first retrive using get 
		session.delete(student1);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}

package com.vasanth.hibernateworkshop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMainAppCreate {

	public static void main(String[] args) {
		
		//CRUD - Create, Read, Update and Delete 
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		Student student=new Student(7,"Devlina","Pal");
		
		session.beginTransaction();
		
		
		session.save(student);
		
		
		session.getTransaction().commit();

		
		factory.close();
	
	}

}

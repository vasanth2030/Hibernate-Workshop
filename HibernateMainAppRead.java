package com.vasanth.hibernateworkshop;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMainAppRead {

	public static void main(String[] args) {
		
		//CRUD - Create, Read, Update and Delete 
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();
		
		// session.get method -> To retrieve a single object from the database table
		
		
		
		
		Student stu=session.get(Student.class, 3);
		
		System.out.println(stu);
		
		session.getTransaction().commit();
		
		
		
		
		
		// session.createQuery -> To retrieve multiple objects from the database table
		
		Session session1=factory.getCurrentSession();
		
		session1.beginTransaction();
		
		List<Student> stuList=session1.createQuery("from Student").getResultList();
		
		for(Student s: stuList)
		{
			System.out.println(s);
		}
		
		session1.getTransaction().commit();
		

		
		factory.close();
	
	}

}

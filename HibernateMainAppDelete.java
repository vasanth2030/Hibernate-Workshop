package com.vasanth.hibernateworkshop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMainAppDelete {

	public static void main(String[] args) {
		
		//CRUD - Create, Read, Update and Delete 
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
	
		
		session.beginTransaction();
		
		
//		Student stu=session.get(Student.class, 7);
//		session.delete(stu);
		
		int n=session.createQuery("delete from Student where id in (5,6)").executeUpdate();
		
		session.getTransaction().commit();

		
		factory.close();
	
	}

}

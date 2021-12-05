package com.vasanth.hibernateworkshop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMainAppUpdate {

	public static void main(String[] args) {

		// CRUD - Create, Read, Update and Delete

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		// Update single object data using session.get()

		Student stu = session.get(Student.class, 1);
		stu.setFirstName("Vasanth");

		session.getTransaction().commit();

		// Update multiple data using session.createQuery().executeUpdate();

		Session session1 = factory.getCurrentSession();

		session1.beginTransaction();

		int n=session1.createQuery("update Student set firstName='Vimal' where id in (1,2,3)").executeUpdate();
		System.out.println(n+" rows affected!");

		session1.getTransaction().commit();

		factory.close();

	}

}

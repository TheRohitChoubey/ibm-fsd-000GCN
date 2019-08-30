package com.IBM.fsd.second_maven_demo.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.IBM.fsd.second_maven_demo.Dao.Pet;

public class DatabaseSession {
	public static Session SessionMethod() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pet.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}

package com.IBM.fsd.second_maven_demo.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.IBM.fsd.second_maven_demo.Dao.PetServiceImpl;

public class DatabaseSession {
	public static SessionFactory SessionMethod() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(PetServiceImpl.class)
				.buildSessionFactory();
		return factory;
	}
}

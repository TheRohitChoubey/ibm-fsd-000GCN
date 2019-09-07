package com.IBM.fsd.myFirst_maven_demo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.IBM.fsd.myFirst_maven_demo.factory.Employee;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(Employee.class).buildSessionFactory();
			Session session = factory.openSession();
			/*
			 * Employee emp = new Employee("sourav" , "Ganguly" , "dada@dd.com");
			session.getTransaction().begin();
			session.persist(emp);
			System.out.println("inserted...!!");
			session.getTransaction().commit();
			*/
			Query query = session .createQuery("from Employee");
			
			List<Employee> list = query.getResultList();
			
			for(Employee e : list) {
				System.out.println(e.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
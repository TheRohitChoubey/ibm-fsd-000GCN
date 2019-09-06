package com.IBm._jdbc_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.IBm._jdbc_annotation.beans.Employee;
import com.IBm._jdbc_annotation.beans.EmployeeDAO;
import com.IBm._jdbc_annotation.beans.SportConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*
		 * ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); EmployeeDAO dao =
		 * context.getBean("eDao", EmployeeDAO.class); dao.createEmployee(new
		 * Employee("Sourav")); dao.getEmployee(1);
		 */

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		EmployeeDAO dao = context.getBean("eDao", EmployeeDAO.class);
		dao.createEmployee(new Employee("Sourav"));
		dao.getEmployee(1);
	}
}

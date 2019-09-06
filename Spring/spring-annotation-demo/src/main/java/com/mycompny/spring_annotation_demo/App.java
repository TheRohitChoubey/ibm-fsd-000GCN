package com.mycompny.spring_annotation_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompny.spring_annotation_demo.bean.Coach;
import com.mycompny.spring_annotation_demo.bean.Employee;
import com.mycompny.spring_annotation_demo.bean.EmployeeDAO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDAO dao = context.getBean("eDao", EmployeeDAO.class);
		dao.createEmployee(new Employee("Sourav"));
		dao.getEmployee(1);
	}
}

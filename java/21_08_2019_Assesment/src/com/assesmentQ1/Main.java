package com.assesmentQ1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<Employee>();

		System.out.println("Input the number of employees : ");
		int noOfEmps = scanner.nextInt();

		for (int i = 1; i <= noOfEmps; i++) {
			System.out.println("Enter the details for employee " + i + " ");
			
			String name = scanner.next();
			String department = scanner.next();
			String doj = scanner.next();
			int age = scanner.nextInt();
			int salary = scanner.nextInt();

			emps.add(new Employee(i,name, department, doj, age, salary));
		}
		
		System.out.println("1. Sort by Salary\n2.Sort by Age and Date of Joining\n3.Print Details");
		System.out.println("Enter your Choice = ");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(emps);
			EmployeeBO.printEmployees(emps);
			break;
		case 2:
			Collections.sort(emps, new AgeComparator());
			EmployeeBO.printEmployees(emps);
			break;
		case 3:
			EmployeeBO.printEmployees(emps);
			break;
		}
		
		 
	}

}

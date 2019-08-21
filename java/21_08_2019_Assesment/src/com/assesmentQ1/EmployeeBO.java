package com.assesmentQ1;

import java.util.*;

public class EmployeeBO {
	
	public static void printEmployees(List emps) {
		Iterator<Employee> i = emps.iterator();
	      System.out.println("Employee Details :");
	      while (i.hasNext()) {
	         System.out.println(i.next());
	      }
	}

}

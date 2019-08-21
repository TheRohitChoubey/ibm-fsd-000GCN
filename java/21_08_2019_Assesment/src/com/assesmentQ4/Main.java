package com.assesmentQ4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.assesmentQ1.AgeComparator;
import com.assesmentQ1.Employee;
import com.assesmentQ1.EmployeeBO;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Contact> cons = new ArrayList<Contact>();

		System.out.println("Input the number of Contacts : ");
		int noOfCons = scanner.nextInt();

		for (int i = 1; i <= noOfCons; i++) {
			System.out.println("Enter name");
			String name = scanner.next();
			
			System.out.println("Enter email");
			String email = scanner.next();
			
			System.out.println("Enter mobile");
			Long mobile = scanner.nextLong();
			
			System.out.println("Enter address");
			String address = scanner.next();

			cons.add(new Contact(name, email, mobile, address));
		}
		
		System.out.println("Contact list after sort by mobile number in descending order");
		Collections.sort(cons);

	}
}

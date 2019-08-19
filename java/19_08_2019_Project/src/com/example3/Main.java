package com.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Data> li = new ArrayList<Data>();
		int id;
		String fname;
		String lname;
		double gpa;

		boolean n = true;
		String ans;
		String ch;

		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("1. Delete");

		ch = sc.next();

		switch (ch) {

		case "1":
			while (n) {
				System.out.println("Do you want to add : ");
				ans = sc.next();
				if (ans == "y") {
					id = sc.nextInt();
					fname = sc.next();
					lname = sc.next();
					gpa = sc.nextDouble();

					li.add(new Data(id, fname, lname, gpa));
				} else {
					n = false;
				}
			}

			break;
		
		case "2" :
			
			
		}

	}
}

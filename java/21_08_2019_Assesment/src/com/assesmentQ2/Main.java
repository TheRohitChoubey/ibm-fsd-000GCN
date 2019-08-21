package com.assesmentQ2;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String pass = scanner.next();
		boolean match =UserMainCode.checkPassword(pass);
		
		if(match == true) {
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Invalid Password");
		}
			
	}

}

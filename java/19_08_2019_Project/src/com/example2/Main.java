package com.example2;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set = new TreeSet<Student>();
		
		set.add(new Student("A","B",4.3));
		set.add(new Student("A","B",2.9));
		set.add(new Student("A","B",4));
		set.add(new Student("A","B",3));
		
		Object[] obj = set.toArray();
		Student s= null;
		
		for(Object o :obj) {
			s= (Student)o;
			System.out.printf("\nname : %s %s GPA : %.1f",s.getFirstName(),s.getLastName(),s.getGpa() );
		}
	}

}

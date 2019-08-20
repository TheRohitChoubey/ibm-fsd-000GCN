package com.example_ExceptionMenuDriverCollection;

import java.util.Set;
import java.util.TreeSet;

public class Data  implements Comparable<Object>{
	private String id;
	private String name;
	private double gpa;
	Set<Data> list = new TreeSet<Data>();

	public Data() {
		super();
	}

	public Data(String id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", gpa=" + gpa;
	}
	
	public void addStudent(String id, String name, double gpa) {
		list.add(new Data(id,name,gpa));
	}

	public void viewStudents() {
		for(Data s: list)
		System.out.println(s);
	}
	
	public void deleteStudent(String id) throws ObjectNotFoundException {
		boolean flag = false;
		for(Data s: list) {
			if(s.getId().equals(id))
				{
				list.remove(s);
				flag =true;
				break;
				}
			else {
				
			}
		}
		if(flag == true) {
			System.out.println("item deleted!!");
		}
		else {
			throw new ObjectNotFoundException("Wrong index entered. try entering correct id..");
		}
	}
	
	public void updateStudent(String id, String name, double gpa) throws ObjectNotFoundException {
		boolean flag = false;
		for(Data s: list) {
			if(s.getId().equals(id))
				{
				s.setName(name);
				s.setGpa(gpa);
				flag =true;
				break;
				}
			else {
				
			}
		}
		if(flag == true) {
			System.out.println("item updated!!");
		}
		else {
			throw new ObjectNotFoundException("Wrong index entered. try entering correct id..");
		}
	}
	
	
	@Override
	public int compareTo(Object o) {
		Data s = (Data)o;
		if(this.getGpa() == s.getGpa()) {
			return 0;
		}
		else if(this.getGpa() > s.getGpa()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
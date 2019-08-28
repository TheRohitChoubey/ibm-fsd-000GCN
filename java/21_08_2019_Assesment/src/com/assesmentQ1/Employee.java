package com.assesmentQ1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Employee implements Comparable<Employee> {
	private int id=0;
	private String name;
	private String department;
	private Date dateOfJoining;
	private int age;
	private int salary;
	
	public Employee() {
		super();
	}

	public Employee(int id,String name, String department, String dateOfJoining, int age, int salary) {
		
		super();
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		this.id = id;
		this.name = name;
		this.department = department;
		try {
			this.dateOfJoining = format.parse(dateOfJoining);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee e) {
		if(this.salary == e.salary) {
			return 0;
		}
		else if(this.salary > e.salary) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", dateOfJoining="
				+ dateOfJoining + ", age=" + age + ", salary=" + salary + "]";
	}

}

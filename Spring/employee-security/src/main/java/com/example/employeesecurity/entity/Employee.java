package com.example.employeesecurity.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String contractSalary;
	private String contractPeriod;
	private String salary;
	private String commision;
	private String eType;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String contractSalary,
			String contractPeriod, String salary, String commision, String eType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contractSalary = contractSalary;
		this.contractPeriod = contractPeriod;
		this.salary = salary;
		this.commision = commision;
		this.eType = eType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContractSalary() {
		return contractSalary;
	}

	public void setContractSalary(String contractSalary) {
		this.contractSalary = contractSalary;
	}

	public String getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCommision() {
		return commision;
	}

	public void setCommision(String commision) {
		this.commision = commision;
	}

	public String geteType() {
		return eType;
	}

	public void seteType(String eType) {
		this.eType = eType;
	}
	
	
	
}
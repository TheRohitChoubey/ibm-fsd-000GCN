package com.example3;

public class Data {
	private int id;
	private String fname;
	private String lname;
	private double gpa;

	public Data(int id, String fname, String lname, double gpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
}

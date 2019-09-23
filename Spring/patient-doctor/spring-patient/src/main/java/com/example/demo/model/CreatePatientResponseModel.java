package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePatientResponseModel {
	
	private String firstName;
	private String lastName;
	private String email;
	private String disease;
	
	
	public CreatePatientResponseModel() {
		super();
	}

	public CreatePatientResponseModel(String firstName, String lastName, String email, String disease) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.disease = disease;
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

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	
}

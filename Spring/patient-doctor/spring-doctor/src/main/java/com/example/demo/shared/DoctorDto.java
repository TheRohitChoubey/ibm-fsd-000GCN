package com.example.demo.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto {

	private String firstName;
	private String lastName;
	private String email;
	private String speciality;
	
	public DoctorDto() {
		super();
	}
	
	public DoctorDto(String firstName, String lastName, String email, String speciality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.speciality = speciality;
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	
}

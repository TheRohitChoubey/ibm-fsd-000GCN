package com.mycompany.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserResponseModel {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	public CreateUserResponseModel(String userId, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	
	
}

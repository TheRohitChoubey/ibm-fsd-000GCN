package com.example3;

public class ObjectNotFoundException extends Throwable{
	private String message;
	public ObjectNotFoundException() {
	}
	
	public ObjectNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
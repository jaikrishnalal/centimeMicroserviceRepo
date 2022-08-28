package com.personal.application3.userservice.model;

import javax.validation.constraints.NotBlank;

public class User {
	
	@NotBlank(message = "First Name cannot be null")
	private String firstName;
	
	@NotBlank(message = "Sur Name cannot be null")
	private String surName;
	
	public User() {	
	}
	
	public User(String firstName, String surName) {
		 
		this.firstName = firstName;
		this.surName = surName;
		
	}
 
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	
	
	
}

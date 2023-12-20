package com.tap.vaccine.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidForgotPasswordCredentials extends Exception {

	public InvalidForgotPasswordCredentials() {
		
		System.out.println("Object Created By IOC Container for InvalidForgotPasswordCredentials()..");
	}
	
	public InvalidForgotPasswordCredentials(String string) {
		super(string);
	
	}
	

}
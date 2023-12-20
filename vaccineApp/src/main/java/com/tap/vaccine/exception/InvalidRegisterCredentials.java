package com.tap.vaccine.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidRegisterCredentials extends Exception {

	public InvalidRegisterCredentials() {
		
		System.out.println("ObjectCreated By IOC Container for InvalidRegisterCredentials()");
	}
	
	public InvalidRegisterCredentials(String string) {

		super(string);
	}
	
	
	
	

}
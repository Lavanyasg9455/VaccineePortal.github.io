package com.tap.vaccine.exception;

import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class InvalidLoginCredentials extends Exception {

	public InvalidLoginCredentials() {
		System.out.println("Object created by IOC Container for InvalidLoginCredentials()");
	}

	public InvalidLoginCredentials(String string) {
		 super(string);
	}

}


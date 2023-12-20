package com.tap.vaccine.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidMemberCredentials extends Exception  {


		public InvalidMemberCredentials() {
			
			System.out.println("ObjectCreated By IOC Container for InvalidMemberCredentials()");
		}
		
		public InvalidMemberCredentials(String string) {

			super(string);
		}	

}



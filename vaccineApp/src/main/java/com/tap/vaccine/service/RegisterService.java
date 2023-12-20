package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.exception.InvalidRegisterCredentials;

@Component
public class RegisterService {

	private RegisterDAO registerDAO;
	
	@Autowired
	public RegisterService(RegisterDAO registerDAO) {
		System.out.println("Invoked RegisterDAO..");
		this.registerDAO = registerDAO;
	}

	public RegisterService() { 
		System.out.println("Object Created by IOC Container for RegisterService()..");
	}
	
	public boolean validateRegisterDetails(String userName,String emailId,long mobileNo,String gender,
			String dateOfBirth,String password,String confirmPassword) throws InvalidRegisterCredentials{
		System.out.println("Invoked validateRegisterDetails()..");
		boolean userNameValid=false;
		boolean emailIdValid=false;
		boolean mobileNoValid=false;
		boolean genderValid=false;
		boolean dateOfBirthValid=false;
		boolean passwordValid=false;
		boolean confirmPasswordValid=false;
		
		if(userName!=null && !userName.isEmpty() && !userName.isBlank()) {
			System.out.println("userName is valid..");
			userNameValid=true;
		}else {
			throw new InvalidRegisterCredentials("Enter Valid UserName");
		}
		
		if(emailId!=null && !emailId.isEmpty() && !emailId.isBlank() ) {
			System.out.println("emailId is valid..");
			emailIdValid=true;
		}else {
			throw new InvalidRegisterCredentials("emailId is Invalid..");
		}
		
		if(mobileNo>0 && String.valueOf(mobileNo).length()==10) {
			System.out.println("mobileNo is valid..");
			mobileNoValid=true;
		}else {
			throw new InvalidRegisterCredentials("Enter Valid MobileNo");
		}
		
		if(gender!=null && !gender.isEmpty() && !gender.isBlank()) {
			System.out.println("gender is valid..");
			genderValid=true;
		}else {
			throw new InvalidRegisterCredentials("Select Valid Gender ");
		}
		
		if(dateOfBirth!=null && !dateOfBirth.isEmpty() && !dateOfBirth.isBlank()) {
			System.out.println("dateOfBirth is valid..");
			dateOfBirthValid=true;
		}else {
			throw new InvalidRegisterCredentials("Enter Valid Date Of Birth");
		}
		
		if(password!=null && !password.isEmpty() && !password.isBlank()) {
			System.out.println("password is valid..");
			passwordValid=true;
		}else {
			throw new InvalidRegisterCredentials("Enter Valid Password");
		}
		
		if(confirmPassword!=null && !confirmPassword.isEmpty() && !confirmPassword.isBlank() && confirmPassword.equals(password)) {
			System.out.println("Password Match..");
			confirmPasswordValid=true;
		}else {
			throw new InvalidRegisterCredentials("Password do not match.. Try again");
		}
		return userNameValid && emailIdValid && mobileNoValid && genderValid &&dateOfBirthValid && passwordValid && confirmPasswordValid;
		
	}
	
	public boolean saveRegisterDetails(String userName,String emailId,long mobileNo,String gender,
			String dateOfBirth,String password,String confirmPassword) {
		
		System.out.println("Invoked saveRegisterDetails()..");
		RegisterEntity entity=new RegisterEntity(userName,emailId,mobileNo,gender,dateOfBirth,password);
		return registerDAO.saveRegisterEntity(entity);
	}
	
	public boolean emailValid(String emailId){
		System.out.println("Invoked emailValid()..");
		return registerDAO.emailCheck(emailId);
	}
	
	

}
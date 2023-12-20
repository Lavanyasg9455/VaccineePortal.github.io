package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.exception.InvalidLoginCredentials;

@Component
public class LoginService {
	
	@Autowired
	private EmailService emailService;
	
	public LoginService(EmailService emailService) {
		
		System.out.println("Invoked EmailService()..");
		this.emailService = emailService;
	}
	
	private LoginDAO loginDAO;
	
	@Autowired
	public LoginService(LoginDAO loginDAO) {
		
		System.out.println("Invoked LoginService()..");
		this.loginDAO = loginDAO;
	}
	private static final int maxLoginAttempt=2;
	
	public boolean validateLoginCredentials(String emailId,String password) throws InvalidLoginCredentials {
		
		boolean validEmailId=false;
		boolean validPassword=false;
		
		
		if(emailId!=null && !emailId.isEmpty() && !emailId.isBlank() ) {
			System.out.println("emailId is valid..");
			validEmailId=true;
		}else {
			throw new InvalidLoginCredentials("Invalid EmailId! EmailId doesn't exist.");
			
		}
		
		if(password!=null && !password.isEmpty() && !password.isBlank()) {
			System.out.println("password is valid..");
			validPassword=true;
		}else {
			throw new InvalidLoginCredentials("Invalid Password! password cannot be null or empty");
		}
		return validEmailId && validPassword;
	}
	
	public RegisterEntity verifyLogin(String emailId,String password )throws InvalidLoginCredentials{

		System.out.println("Invoked loginValid()..");
	
		RegisterEntity entity=loginDAO.getRegisterEntityByEmail(emailId);
			if(entity!=null && entity.getPassword().equals(password)) {
				return entity;
			}else {
				throw new InvalidLoginCredentials("Incorrect Email or Password Check Once..");
			}
	}
	
	public boolean countLoginAttempt(String emailId,String password)throws InvalidLoginCredentials{
		
		System.out.println("Invoked countLoginAttempt()..");
		boolean flag=false;
		
		RegisterEntity entity=loginDAO.getRegisterEntityByEmail(emailId);
		if(entity!=null) {
			if (entity.getLoginAttempt()>=maxLoginAttempt) {
				emailService.sendAccountBlockEmail(entity);
				throw new InvalidLoginCredentials("Account Is Blocked! Due To Too Many Attempts. Please Reset The Password To Unblock");
			}
			if (entity.getPassword().equals(password)) {
				flag=true;
			}else {
				int loginAttempt=entity.getLoginAttempt();
				int attempts=maxLoginAttempt-loginAttempt;
				loginDAO.updateLoginAttempt(emailId,loginAttempt);
				throw new InvalidLoginCredentials("Invalid Login Credentials" + "  " + attempts +" "+ "More Attempt Left");
			}
		}else {
			
			throw new InvalidLoginCredentials("EmailId does not exist");
		}
		return flag;
	}

}
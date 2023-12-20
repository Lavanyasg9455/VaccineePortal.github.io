package com.tap.vaccine.service;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.ForgotPasswordDAO;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.exception.InvalidForgotPasswordCredentials;
import com.tap.vaccine.exception.InvalidRegisterCredentials;

@Component
public class ForgotPasswordService {
	
	@Autowired
	private EmailService emailService;
	
	public ForgotPasswordService(EmailService emailService) {
		
		System.out.println("Invoked EmailService()..");
		this.emailService = emailService;
	}
	
	private ForgotPasswordDAO forgotPasswordDAO;
	
	@Autowired
	public ForgotPasswordService(ForgotPasswordDAO forgotPasswordDAO) {
		
		System.out.println("Invoked ForgotPasswordDAO()..");
		this.forgotPasswordDAO = forgotPasswordDAO;
	}

	public boolean validateUserData(String emailId,String newPassword,String confirmPassword) throws InvalidForgotPasswordCredentials {
		
		boolean emailIdValid=false; 
		boolean newPasswordValid=false;
		boolean confirmPasswordValid=false;
		
		if(emailId!=null && !emailId.isEmpty() && !emailId.isBlank() ) {
			System.out.println("emailId is valid..");
			emailIdValid=true;
		}else {
			throw new InvalidForgotPasswordCredentials("Enter a Valid Email");
		}
		
		if(newPassword!=null && !newPassword.isEmpty() && !newPassword.isBlank() ) {
			System.out.println("Enter Valid Password");
			newPasswordValid=true;	
		}else {
			throw new InvalidForgotPasswordCredentials("Enter Valid Password");
		}
		
		if(confirmPassword!=null && !confirmPassword.isEmpty() && !confirmPassword.isBlank() && confirmPassword.equals(newPassword)) {
			System.out.println("Password Match..");
			confirmPasswordValid=true;
		}else {
			throw new InvalidForgotPasswordCredentials("Password do not match.. Try again");
		}
		return emailIdValid && newPasswordValid && confirmPasswordValid;
	}
	
	public boolean resetPasswordByEmail(String emailId, String newPassword) throws InvalidForgotPasswordCredentials {
		
		boolean flag=false;

		RegisterEntity entity = forgotPasswordDAO.getRegisterEntityByEmail(emailId);
		if (entity != null) {
			boolean result = forgotPasswordDAO.updateNewPasswordByEmail(emailId, newPassword);
			if (result) {
				boolean emailSentMessage = emailService.sendUpdatedPasswordMail(entity);
				if (emailSentMessage) {
					System.out.println("Email Sent Successfully With Updated Password.. ");
					flag=true;
				} else {
					throw new InvalidForgotPasswordCredentials("Something Went wrong! Check Your Internet Connection.");
				}
			}
		} else {
			throw new InvalidForgotPasswordCredentials("Email Does Not Exist!");
		}
		return flag;

	}

}
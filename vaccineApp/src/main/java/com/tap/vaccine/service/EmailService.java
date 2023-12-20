package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class EmailService {

	public EmailService(){

		System.out.println("Object Created By IOC Container EmailService()..");
	}

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public EmailService(JavaMailSenderImpl javaMailSender) {

		System.out.println("Invoked JavaMailSenderImpl()..");
		this.javaMailSender = javaMailSender;
	}

	public boolean sendEmail(RegisterEntity entity){

		System.out.println("Invoked sendEmail()..");
		boolean flag = false;

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(entity.getEmailId());
		simpleMailMessage.setSubject("Registration Succesfull for VaccineApp!");
		simpleMailMessage.setText("Dear" + entity.getUserName() + ",\n\n" 
		+ "Thank you for registering with VaccineApp!\n\n" + "Here are your login credentials:\n"
		+ " -EmailId: " + entity.getEmailId() + "\n" + " -Password: " + entity.getPassword() + "\n\n"
		+ "Note: Keep your login credentials secure and do not share them with anyone.n\n"
		+ "Use these credentials to login to the VaccineApp and stay updated on VaccineApp.n\n"
		+ "Stay Healthy!\n\n" + "Best regards,\n" + "VaccineApp");
		try {
			javaMailSender.send(simpleMailMessage);
			System.out.println("Mail Sent");
			return true;
		} catch (MailException e) {
			String message = e.getMessage();
			String message1 = e.getLocalizedMessage();
			System.out.println(message);
			System.out.println(message1);
			return flag;
		}

	}
	
	public boolean sendAccountBlockEmail(RegisterEntity entity) {

		System.out.println("Invoked sendEmail()..");
		boolean flag = false;

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(entity.getEmailId());
		simpleMailMessage.setSubject("Vaccine Portal Login Details");
		simpleMailMessage.setText("Dear" + entity.getUserName() + ",\n\n" 
		+ "Your Account Is Blocked!\n\n "
		+ "Due To Too Many Attempts. Please Reset The Password & Login Again");
		try {
			javaMailSender.send(simpleMailMessage);
			System.out.println("Mail Sent");
			return true;
		} catch (MailException e) {
			String message = e.getMessage();
			String message1 = e.getLocalizedMessage();
			System.out.println(message);
			System.out.println(message1);
			return flag;
		}

	}
	
	public boolean sendUpdatedPasswordMail(RegisterEntity entity) {
		
		System.out.println("Invoked sendUpdatedPasswordMail()..");
		boolean flag = false;

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(entity.getEmailId());
		simpleMailMessage.setSubject("Password Upadate Succesfull for VaccineApp!");
		simpleMailMessage.setText("Dear" + entity.getUserName() + ",\n\n" 
        + "Your Password Is Updated Successfully\n\n" +"Here are your Updated login credentials:\n"
		+ " -EmailId: " + entity.getEmailId() + "\n" + " -New Password: " + entity.getPassword() + "\n\n"
		+ "Note: Keep your login credentials secure and do not share them with anyone.n\n"
		+ "Use these credentials to login to the VaccineApp and stay updated on VaccineApp.n\n"
		+ "Stay Healthy!\n\n" + "Best regards,\n" + "VaccineApp");
		try {
			javaMailSender.send(simpleMailMessage);
			System.out.println("Mail Sent");
			return true;
		} catch (MailException e) {
			String message = e.getMessage();
			String message1 = e.getLocalizedMessage();
			System.out.println(message);
			System.out.println(message1);
			return flag;
		}
		
	}

}

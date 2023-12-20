package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.exception.InvalidForgotPasswordCredentials;
import com.tap.vaccine.service.ForgotPasswordService;

@Controller
public class ForgotPasswordController {
	
	
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	public ForgotPasswordController(ForgotPasswordService forgotPasswordService) {
		System.out.println("Invoked ForgotPasswordService()..");
		this.forgotPasswordService = forgotPasswordService;
	}

	@RequestMapping(value="/getForgotPasswordPage")
	public String getForgotPasswordPage() {
		return "/WEB-INF/ForgotPassword.jsp";
	}
	
	@RequestMapping(value="/forgotPasswordPage")
	public String forgotPasswordPage(@RequestParam String emailId,
			@RequestParam String newPassword,
			@RequestParam String confirmPassword,Model model) throws InvalidForgotPasswordCredentials {
		
		try {
			boolean validate=forgotPasswordService.validateUserData(emailId,newPassword,confirmPassword);
			if(validate) {
				boolean reset=forgotPasswordService.resetPasswordByEmail(emailId, newPassword);
				if(reset) {
					model.addAttribute("resetPasswordMessage","Password Updated Successfully.Login To Continue.");
					return "/WEB-INF/Login.jsp";
				}
			}
		}catch(InvalidForgotPasswordCredentials e) {
			e.getMessage();
			model.addAttribute("errorPasswordMessage", e.getMessage());
		}
		return "/WEB-INF/ForgotPassword.jsp";	
	}

}
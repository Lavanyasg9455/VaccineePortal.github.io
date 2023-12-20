package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.exception.InvalidRegisterCredentials;
import com.tap.vaccine.service.RegisterService;

@Controller
public class RegisterController {

	private RegisterService registerService;

	@Autowired
	public RegisterController(RegisterService registerService) {

		System.out.println("Invoked RegisterService()..");
		this.registerService = registerService;
	}

	public RegisterController() {
		System.out.println("Object created by IOC container for RegisterController()");
	}

	@RequestMapping(value = "/getSignUpPage")
	public String getSignUpPage() {

		return "/WEB-INF/Register.jsp";
	}

	@RequestMapping(value = "/saveRegister")
	public String save(@RequestParam String userName,
			@RequestParam String emailId,
			@RequestParam long mobileNo,
			@RequestParam String gender,
			@RequestParam String dateOfBirth,
			@RequestParam String password,
			@RequestParam String confirmPassword, Model model)throws InvalidRegisterCredentials {
		System.out.println("Invoked save()...");
			try {
				boolean valid = registerService.validateRegisterDetails(userName, emailId, mobileNo, gender, dateOfBirth,
						password, confirmPassword);
				if (valid) {
					boolean email = registerService.emailValid(emailId);
					if (email) {
						boolean save = registerService.saveRegisterDetails(userName, emailId, mobileNo, gender, dateOfBirth,
								password, confirmPassword);
						if (save) {
							model.addAttribute("registerResponse", "Registered Succesfully.., Login To Continue..");
						} else {
							model.addAttribute("registerResponse", "Something Went Wrong! At the time of registration");
						}
					} else {
						model.addAttribute("registerResponse1", "Email alredy exists..Try with other Email Id");
				    }
				} 
			}catch(InvalidRegisterCredentials e) {
				
				model.addAttribute("registerResponse1",e.getMessage());
			}
		    return "/WEB-INF/Register.jsp";

	}

}

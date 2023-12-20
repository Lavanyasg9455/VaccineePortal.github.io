package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.exception.InvalidLoginCredentials;
import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController {
	
	public static String userEmail;
	
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		
		System.out.println("Invoked LoginController()..");
		this.loginService = loginService;
	}
	
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage() {
		return "/WEB-INF/Login.jsp";
	}
	

	@RequestMapping(value = "/loginPage")
	public String loginPage(@RequestParam String emailId, @RequestParam String password, Model model, HttpServletRequest request) {
	    try {
	        boolean validUser = loginService.validateLoginCredentials(emailId, password);
	        if (validUser) {
	            boolean result = loginService.countLoginAttempt(emailId, password);
	            if (result) {
	                RegisterEntity entity = loginService.verifyLogin(emailId, password);
	                model.addAttribute("memCount", entity.getMemberCount());
	                if (entity != null) {
	                    HttpSession session = request.getSession(true);
	                    session.setAttribute("userEmail", emailId);
	                    userEmail = (String) session.getAttribute("userEmail");
	                    model.addAttribute("memCount", entity.getMemberCount());
	                    System.out.println("Invoked memCount..");
	                    return "/WEB-INF/HomePage.jsp";
	                }
	            }
	        }
	    } catch (InvalidLoginCredentials e) {
	        model.addAttribute("loginMessage1", "Login Failed" + " " + e.getMessage());
	    }
	    return "/WEB-INF/Login.jsp";
	}
}

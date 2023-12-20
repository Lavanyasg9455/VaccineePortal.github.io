package com.tap.vaccine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false); // 'false' means do not create a new session if not exists

		// Invalidate the session if it exists
		if (session != null) {
			String s = (String) (session.getAttribute("emailId"));
			session.invalidate();
		}
		return "forward:/WEB-INF/Login.jsp";
	}

}
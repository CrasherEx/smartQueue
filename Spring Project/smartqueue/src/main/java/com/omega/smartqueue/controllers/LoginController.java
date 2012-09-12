package com.omega.smartqueue.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omega.smartqueue.daos.LoginInformationDAO;
import com.omega.smartqueue.model.LoginInformation;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public String submitLogin(HttpServletRequest request,
								@RequestParam("username") String username, 
								@RequestParam("password") String password) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
		LoginInformationDAO loginInformationDAO = (LoginInformationDAO) context.getBean("loginInformationDAO");
		LoginInformation loginInformation = loginInformationDAO.findByUsername(username);
		if(loginInformation == null)
		{
			request.setAttribute("message", "User " + username + " doesn't exist;");
			return "loginFailure";
		}
		else
		{
			if(!loginInformation.getPassword().equals(password))
			{
				request.setAttribute("message", "The password doesn't match the user. <br/><br/> " +
						"You typed: <br/>" +
						"Username= <b>" + username + "</b><br/>" +
						"Password= <b>" + password + "</b><br/>" +
						"<br/>" +
						"The correct: <br/>" +
						"Username= <b>" + loginInformation.getUsername() + "</b><br/>" +
						"Password= <b>" + loginInformation.getPassword() + "</b>");
				return "loginFailure";
			}
		}

		return "loginSuccess";
	}
	
}

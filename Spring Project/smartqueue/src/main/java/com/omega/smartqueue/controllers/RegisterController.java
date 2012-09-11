package com.omega.smartqueue.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omega.smartqueue.daos.LoginInformationDAO;
import com.omega.smartqueue.model.LoginInformation;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/submitRegister", method = RequestMethod.POST)
	public String submitRegister(@RequestParam("username") String username, 
								 @RequestParam("password") String password) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
		LoginInformationDAO loginInformationDAO = (LoginInformationDAO) context.getBean("loginInformationDAO");
		LoginInformation loginInformation = new LoginInformation(username,password);
		loginInformationDAO.insert(loginInformation);

		return "register";
	}
	
}

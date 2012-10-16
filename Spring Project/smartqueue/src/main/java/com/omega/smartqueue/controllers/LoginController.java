package com.omega.smartqueue.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omega.smartqueue.daos.CustomerDAO;
import com.omega.smartqueue.enums.UserType;
import com.omega.smartqueue.model.Customer;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login/customer/main";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public String submitLogin(HttpServletRequest request)
	{
		
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		String inputRememberMe = request.getParameter("inputRememberMe");
		
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		if(inputEmail == null)
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.add("O campo <b>E-mail</b> necessita ser preenchido");
		}
		else if(inputEmail.equals(""))
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.add("O campo <b>E-Mail</b> necessita ser preenchido");
		}
		if(inputPassword == null)
		{
			request.setAttribute("inputPasswordError",true);
			errorMessages.add("O campo <b>Senha</b> necessita ser preenchido");
		}
		else if(inputPassword.equals(""))
		{
			request.setAttribute("inputPasswordError",true);
			errorMessages.add("O campo <b>Senha</b> necessita ser preenchido");
		}
		
		if(errorMessages.size()>0)
		{
			request.setAttribute("errorMessages",errorMessages);
			return "login/customer/main";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("CustomerDAO");
		ArrayList<Customer> customerList = (ArrayList<Customer>) customerDAO.selectByEmail(inputEmail);
		
		if(customerList.size() == 0)
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.add("<b>Usuário</b> inexistente.");
		}
		else if(customerList.size() == 1)
		{
			Customer customer = customerList.get(0);
			if(inputPassword.equals(customer.getPassword()) == false)
			{
				request.setAttribute("inputPasswordError",true);
				errorMessages.add("<b>Senha</b> incorreta.");
			}
			else
			{
				HttpSession session = request.getSession();
				if(inputRememberMe != null)
				{
					if(inputRememberMe.equals("true"))
					{
						session.setMaxInactiveInterval(365*24*60*60);
					}
				}
				session.setAttribute("userId",customer.getCustomer_id());
				session.setAttribute("userType",UserType.CUSTOMER);
				return "home";
			}
		}
		else
		{
			request.setAttribute("inputEmailError",true);
			request.setAttribute("inputPasswordError",true);
			errorMessages.add("Um erro interno ocorreu. Contate o SAC imediatamente. <b>Erro:</b> Usuários múltiplos detectados.");
		}

		request.setAttribute("errorMessages",errorMessages);
		return "login/customer/main";
	}
	
}

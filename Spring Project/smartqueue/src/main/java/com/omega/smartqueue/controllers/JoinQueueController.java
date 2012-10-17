package com.omega.smartqueue.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.omega.smartqueue.daos.CustomerDAO;
import com.omega.smartqueue.enums.UserType;
import com.omega.smartqueue.model.Customer;

@Controller
public class JoinQueueController
{
	@RequestMapping(value = "confirmjoinqueue", method = RequestMethod.GET)
	public String joinQueue(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ArrayList<String> errorMessages = new ArrayList<String>();
		int ID = (Integer)session.getAttribute("userId");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomerDAO customerDAO= (CustomerDAO) context.getBean("CustomerDAO");
		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.selectById(ID);
		String customerName = (customers.get(0)).getName();
		String customerTel = (customers.get(0)).getTelephone();
		
		if(session.getAttribute("userId") == null && session.getAttribute("userType") == null)
		{
			errorMessages.add("Você precisa estar logado para entrar em uma fila. " +
					"Caso deseje fazer login, <a href='login'>clique aqui</a>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		if(session.getAttribute("userId") == null || session.getAttribute("userType") == null)
		{
			//Erro fatal do sistema. Não tem que acontecer de jeito nenhum.
			errorMessages.add("Something wrong just happened.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
			
		}
		
		if(session.getAttribute("userType") == UserType.RESTAURANT)
		{
			errorMessages.add("Restaurantes não podem entrar em fila. Efetue login como <b>cliente</b>.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		if(session.getAttribute("userId") != null && session.getAttribute("userType") == UserType.CUSTOMER)
		{
			request.setAttribute("customerName",customerName);
			request.setAttribute("customerTel", customerTel);
			return "confirmjoinqueue";
		}
	}
	
	@RequestMapping(value = "joinqueue", method = RequestMethod.POST)
	public String joinQueue(HttpServletRequest request)
	{	
		return "joinqueue";
	}
}

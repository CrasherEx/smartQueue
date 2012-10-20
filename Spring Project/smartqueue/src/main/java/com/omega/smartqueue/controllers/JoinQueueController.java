package com.omega.smartqueue.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omega.smartqueue.daos.CustomerDAO;
import com.omega.smartqueue.daos.QueuesDAO;
import com.omega.smartqueue.daos.RestaurantDAO;
import com.omega.smartqueue.enums.UserType;
import com.omega.smartqueue.model.Customer;
import com.omega.smartqueue.model.CustomerInQueue;
import com.omega.smartqueue.model.Restaurant;

@Controller
public class JoinQueueController
{
	@RequestMapping(value = "confirmjoinqueue", method = RequestMethod.GET)
	public String confirmJoinQueue(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		UserType userType = (UserType) session.getAttribute("userType");
		
		if(userId == null && userType == null)
		{
			errorMessages.add("Você precisa estar logado para entrar em uma fila. Acesse nossa <a href='login'>página de login</a> para logar-se.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		else if(userId == null || userType == null)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Chave <u>id/tipo</u> de login parcialmente nula</b>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";	
		}
		
		if(userType != UserType.CUSTOMER)
		{
			errorMessages.add("É necessário ser um <b>cliente</b> para entrar na fila de um restaurante.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		// A partir daqui já é possivel considerar que é um cliente
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomerDAO customerDAO= (CustomerDAO) context.getBean("CustomerDAO");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");

		String inputRestaurantId = request.getParameter("restaurant");
		if(inputRestaurantId == null)
		{
			errorMessages.add("Restaurante nulo.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		try
		{
			Integer restaurantId = Integer.parseInt(inputRestaurantId);
			ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectById(restaurantId);
			
			if(restaurants.size() == 0)
			{
				errorMessages.add("Restaurante inexistente.");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			else if(restaurants.size() > 1)
			{
				errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada múltipla de restaurantes</b>");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			
			Restaurant restaurant = restaurants.get(0);
			request.setAttribute("restaurant",restaurant);
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Restaurante inválido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.selectById(userId);
		
		if(customers.size() == 0)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Usuário logado com conta inexistente</b>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		else if(customers.size() > 1)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada múltipla de usuários</b>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		Customer customer = customers.get(0);

		request.setAttribute("customer",customer);
		return "confirmjoinqueue";
	}
	
	@RequestMapping(value = "joinqueue", method = RequestMethod.POST)
	public String joinQueue(HttpServletRequest request)
	{	
		HttpSession session = request.getSession();
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		UserType userType = (UserType) session.getAttribute("userType");
		
		if(userId == null && userType == null)
		{
			errorMessages.add("Você precisa estar logado para entrar em uma fila. Acesse nossa <a href='login'>página de login</a> para logar-se.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		else if(userId == null || userType == null)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Chave <u>id/tipo</u> de login parcialmente nula</b>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";	
		}
		
		if(userType != UserType.CUSTOMER)
		{
			errorMessages.add("É necessário ser um <b>cliente</b> para entrar na fila de um restaurante.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
		
		String inputRestaurantId = request.getParameter("restaurant");
		
		if(inputRestaurantId == null)
		{
			errorMessages.add("Restaurante nulo.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		try
		{
			Integer restaurantId = Integer.parseInt(inputRestaurantId);
			ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectById(restaurantId);
			
			if(restaurants.size() == 0)
			{
				errorMessages.add("Restaurante inexistente.");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			else if(restaurants.size() > 1)
			{
				errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada múltipla de restaurantes</b>");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			
			String name = (String) request.getParameter("name");
			String telephone = (String) request.getParameter("telephone");
			
			String inputParty = request.getParameter("party");
			if(inputParty == null)
			{
				errorMessages.add("Por favor, preencha o número de pessoas que entrarão na fila");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			
			try
			{
				Integer party = Integer.parseInt(inputParty);
				CustomerInQueue customerToAdd = new CustomerInQueue(restaurantId,name,party,telephone,userId);
				
				try
				{
					queuesDAO.create(customerToAdd);
				}
				catch(DataIntegrityViolationException dataIntegrityViolationException)
				{
					errorMessages.add("Você já está dentro de uma fila.");
					request.setAttribute("errorMessages",errorMessages);
					return "error";
				}
			}
			catch(NumberFormatException numberFormatException)
			{
				errorMessages.add("Número de pessoas inválido.");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Restaurante inválido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		return "home";
	}
	
}

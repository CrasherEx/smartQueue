package com.omega.smartqueue.controllers;

import com.omega.smartqueue.validators.*;
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

/**
	 * Controller que coordena como o cliente entra na fila e valida a sua entrada.
	 * Apenas clientes est�o aptos a entrar na fila.
	 * 
	 * @version 2.0, November 2012
	 * @see validators Package com as classes de valida��o.
*/

@Controller
public class JoinQueueController
{
	/**
	 * @return P�gina que mostrar� quaisquer erros
	 * @return P�gina de confinrma��o para entrar na p�gina
	 * @param request O request enviado pelo cliente
	 */
	@RequestMapping(value = "confirmjoinqueue", method = RequestMethod.GET)
	public String confirmJoinQueue(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		//ArrayLists to save the errors and show it later.
		ArrayList<String> errorMessages = new ArrayList<String>();
		ArrayList<String> typeValidatorErrors = new ArrayList<String>();
		ArrayList<String> restaurantValidatorErrors = new ArrayList<String>();
		ArrayList<String> customerValidatorErrors = new ArrayList<String>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		UserType userType = (UserType) session.getAttribute("userType");
		
		TypeValidator typeValidator = new TypeValidator();
		
		typeValidatorErrors = typeValidator.validate(userId,userType,UserType.CUSTOMER);
		errorMessages.addAll(typeValidatorErrors);
		
		// Return error if the user is not a customer.
		if (!typeValidatorErrors.isEmpty())
		{
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		
		// From here on, the user can only be a customer.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomerDAO customerDAO= (CustomerDAO) context.getBean("CustomerDAO");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");

		String inputRestaurantId = request.getParameter("restaurant");
		RestaurantValidator restaurantValidator = new RestaurantValidator();
		
		
		try
		{
			Integer restaurantId = Integer.parseInt(inputRestaurantId);
			ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectById(restaurantId);
			restaurantValidatorErrors = restaurantValidator.validate(restaurantId, restaurants);
			errorMessages.addAll(restaurantValidatorErrors);
			
			Restaurant restaurant = restaurants.get(0);
			request.setAttribute("restaurant",restaurant);
			if (!restaurantValidatorErrors.isEmpty())
			{
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Restaurante inv�lido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.selectById(userId);
		CustomerValidator customerValidator = new CustomerValidator();
		
		customerValidatorErrors = customerValidator.validate(customers);
		errorMessages.addAll(customerValidatorErrors);
		
		if(!customerValidatorErrors.isEmpty())
		{
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		Customer customer = customers.get(0);
		
		// Arriving here, no errors were found. 
		request.setAttribute("customer",customer);
		return "confirmjoinqueue";
	}
	
	/**
	 * @return P�gina que mostrar� quaisquer erros
	 * @return Se o cliente conseguir entrar na fila, volta � p�gina inicial.
	 * @param request O request enviado pelo cliente
	 */
	@RequestMapping(value = "joinqueue", method = RequestMethod.POST)	
	public String joinQueue(HttpServletRequest request)
	{	
		HttpSession session = request.getSession();
		ArrayList<String> errorMessages = new ArrayList<String>();
		ArrayList<String> typeValidatorErrors = new ArrayList<String>();
		ArrayList<String> restaurantValidatorErrors = new ArrayList<String>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		UserType userType = (UserType) session.getAttribute("userType");

		TypeValidator typeValidator = new TypeValidator();
		
		typeValidatorErrors = typeValidator.validate(userId,userType,UserType.CUSTOMER);
		errorMessages.addAll(typeValidatorErrors);
		
		if (!typeValidatorErrors.isEmpty())
		{
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
		
		String inputRestaurantId = request.getParameter("restaurant");
		RestaurantValidator restaurantValidator = new RestaurantValidator();
		
		try
		{
			Integer restaurantId = Integer.parseInt(inputRestaurantId);
			ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectById(restaurantId);
			restaurantValidatorErrors = restaurantValidator.validate(restaurantId, restaurants);
			errorMessages.addAll(restaurantValidatorErrors);
			
			Restaurant restaurant = restaurants.get(0);
			request.setAttribute("restaurant",restaurant);
			if (!restaurantValidatorErrors.isEmpty())
			{
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			
			String name = (String) request.getParameter("name");
			String telephone = (String) request.getParameter("telephone");
			
			String inputParty = request.getParameter("party");
			if(inputParty == null)
			{
				errorMessages.add("Por favor, preencha o n�mero de pessoas que entrar�o na fila");
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
					errorMessages.add("Voc� j� est� dentro de uma fila.");
					request.setAttribute("errorMessages",errorMessages);
					return "error";
				}
			}
			catch(NumberFormatException numberFormatException)
			{
				errorMessages.add("N�mero de pessoas inv�lido.");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Restaurante inv�lido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		// Arriving here, no errors were found.
		return "home";
	}
	
}

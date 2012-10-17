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
			errorMessages.add("Você precisa estar logado para entrar em uma fila. " +
					"Caso deseje fazer login, <a href='login'>clique aqui</a>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		else if(userId == null || userType == null)
		{
			//Erro fatal do sistema. Não tem que acontecer de jeito nenhum.
			errorMessages.add("Something wrong just happened.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";	
		}
		
		if(userType == UserType.RESTAURANT)
		{
			errorMessages.add("Restaurantes não podem entrar em fila. Efetue login como <b>cliente</b>.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		// A partir daqui já é possivel considerar que é um cliente
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomerDAO customerDAO= (CustomerDAO) context.getBean("CustomerDAO");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");

		Integer restaurandId = Integer.parseInt(request.getParameter("restaurant"));
		
		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.selectById(userId);
		ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectById(restaurandId);

		Restaurant restaurant = restaurants.get(0);
		String customerName = customers.get(0).getName();
		String customerTel = customers.get(0).getTelephone();

		request.setAttribute("restaurantId",restaurandId);
		request.setAttribute("restaurantName",restaurant.getName());
		request.setAttribute("queueSize",queuesDAO.selectCustomersInQueue(restaurandId).size());
		request.setAttribute("customerName",customerName);
		request.setAttribute("customerTel", customerTel);
		return "confirmjoinqueue";
	}
	
	@RequestMapping(value = "joinqueue", method = RequestMethod.POST)
	public String joinQueue(HttpServletRequest request)
	{	
		HttpSession session = request.getSession();
		
		Integer customerId = (Integer) session.getAttribute("userId");
		Integer restaurandId = Integer.parseInt(request.getParameter("restaurant"));
		String name = (String) request.getParameter("name");
		String telephone = (String) request.getParameter("telephone");
		Integer party = Integer.parseInt(request.getParameter("party"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
		
		CustomerInQueue customerToAdd = new CustomerInQueue(restaurandId,name,party,telephone,customerId);
		
		queuesDAO.create(customerToAdd);
		
		return "home";
	}
	
	@RequestMapping(value = "/showQueues", method = RequestMethod.GET)
	public String showQueues(HttpServletRequest request)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
		
		ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectAll();
		
		ArrayList<ArrayList<CustomerInQueue>> queues = new ArrayList<ArrayList<CustomerInQueue>>();
		ArrayList<String> names = new ArrayList<String>();
		for(Restaurant restaurant:restaurants)
		{
			queues.add( (ArrayList<CustomerInQueue>) queuesDAO.selectCustomersInQueue(restaurant.getRestaurant_id()));
			names.add(restaurant.getName());
		}

		request.setAttribute("restaurantNames",names);
		request.setAttribute("queues",queues);
		return "showQueues";
	}
	
	@RequestMapping(value = "/removeCustomerFromQueue", method = RequestMethod.POST)
	public String removeCustomerFromQueue(HttpServletRequest request)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Integer id = Integer.parseInt(request.getParameter("id"));
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
		
		queuesDAO.deleteCustomerInQueue(id);
		
		return showQueues(request);
	}
}

package com.omega.smartqueue.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omega.smartqueue.daos.QueuesDAO;
import com.omega.smartqueue.daos.RestaurantDAO;
import com.omega.smartqueue.model.CustomerInQueue;
import com.omega.smartqueue.model.Restaurant;

/**
 * Controller responsável pelas seguintes ações:
 * Visualizar fila
 * Sair da fila
 * Encontrar um restaurante pelo campo de busca
 * 
 * @see daos Package com as principais interface da aplicação
 */

@Controller
public class CustomerActionsController 
{
	/**
	 * Método responsável por exibir os resultados da busca através de uma query no banco de dados.
	 * 
	 * @param request Request enviado pelo cliente
	 * @return Página principal com os resultados da busca.
	 */
	@RequestMapping(value = "results", method = RequestMethod.GET)
	public String results(HttpServletRequest request)
	{
		String restaurantName = request.getParameter("restaurantName");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		
		if(restaurantName == null)
		{
			return "home";
		}
		else
		{
			int indexOfSpace = restaurantName.indexOf(" ");
			int lastIndexOfSpace = restaurantName.lastIndexOf(" ");
			if(indexOfSpace != -1)
			{
				// Checa se o campo é composto somente de " ";
				if(restaurantName.equals(restaurantName.substring(indexOfSpace,lastIndexOfSpace)))
				{
					return "home";
				}
			}
			
			if(restaurantName.equals(""))
			{
				return "home";
			}
			else
			{
				restaurants = (ArrayList<Restaurant>) restaurantDAO.selectByNameSearch(restaurantName);
				request.setAttribute("restaurants", restaurants);
				return "home";
			}
		}
	}
	
	/**
	 * Método responsável por fazer com que o cliente saia da fila.
	 * 
	 * @param request Request enviado pelo cliente
	 * @return Página de erro, caso ocorra algum.
	 * @return Página inicial, caso o usuário consiga sair da fila.
	 */
	
	@RequestMapping(value = "/leaveQueue", method = RequestMethod.GET)	
	public String leaveQueue(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ArrayList<String> errorMessages = new ArrayList<String>();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Integer id = (Integer) session.getAttribute("userId");

		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");

		try
		{
			CustomerInQueue customerInQueue = queuesDAO.selectByCustomerId(id);
			
			try
			{
				queuesDAO.deleteCustomerInQueue(customerInQueue.getCustomer_in_queue_id());
			}
			catch(EmptyResultDataAccessException emptyResultDataAccessException)
			{
				errorMessages.add("Você já não está na fila");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
		}
		catch(EmptyResultDataAccessException emptyResultDataAccessException)
		{
			errorMessages.add("Você já não está na fila");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		return "home";

	}
	

	/**
	 * Método responsável por mostrar a fila de um determinado restaurante
	 * 
	 * @param request Request enviado pelo cliente
	 * @return Página de erro, caso ocorra algum.
	 * @return Página de visualização da fila.
	 */
	@RequestMapping(value = "/viewQueue", method = RequestMethod.GET)
	public String viewQueue(HttpServletRequest request)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		
		String inputRestaurantId = request.getParameter("restaurantId");

		if(inputRestaurantId == null)
		{
			errorMessages.add("Restaurante inválido para ação de visualizar a fila.");
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
			if(restaurants.size() > 1)
			{
				errorMessages.add("Erro Fatal! Contate o SAC imediatament. <b>Erro: Dois restaurantes com o mesmo Id</d>");
				request.setAttribute("errorMessages",errorMessages);
				return "error";	
			}
			Restaurant restaurant = restaurants.get(0);
			request.setAttribute("restaurant", restaurant);
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Restaurante inválido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		return "viewQueue";
	}
}

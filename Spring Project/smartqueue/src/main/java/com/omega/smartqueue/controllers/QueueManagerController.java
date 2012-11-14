package com.omega.smartqueue.controllers;

import java.io.IOException;
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
import com.omega.smartqueue.enums.UserType;
import com.omega.smartqueue.exceptions.ConnectionAuthenticationException;
import com.omega.smartqueue.exceptions.MessageSizeException;
import com.omega.smartqueue.exceptions.NotEnoughCreditsException;
import com.omega.smartqueue.model.CustomerInQueue;
import com.omega.smartqueue.model.Restaurant;
import com.omega.smartqueue.webservices.SMSBRService;

/**
 * Controller respons�vel pelo gerenciamento da fila.
 * Neste constam os m�todos para adicionar e remover um cliente da fila.
 * 
 * @see validators Package com as classes de valida��o
 */

@Controller
public class QueueManagerController 
{

	/**
	 * M�todo respons�vel pelo manuseio da fila.
	 * 
	 * @param request Request enviado pelo cliente.
	 * @return P�gina com os erros, caso ocorra algum.
	 * @return P�gina da interface do restaurante para manuseio da fila.
	 */
	@RequestMapping(value = "/queueManager", method = RequestMethod.GET)
	public String queueManager(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		UserType userType = (UserType) session.getAttribute("userType");
		
		if(userId == null && userType == null)
		{
			errorMessages.add("Voc� precisa estar logado para acessar sua fila. Acesse nossa <a href='login'>p�gina de login</a> para logar-se.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		else if(userId == null || userType == null)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Chave <u>id/tipo</u> de login parcialmente nula</b>");
			request.setAttribute("errorMessages",errorMessages);
			return "error";	
		}
		
		if(userType != UserType.RESTAURANT)
		{
			errorMessages.add("� necess�rio ser um <b>restaurante</b> para acessar o gerenciador de fila.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
		
		//Restaurant restaurant = restaurantDAO.selectById(userId).get(0);
		
		ArrayList<CustomerInQueue> queue = (ArrayList<CustomerInQueue>) queuesDAO.selectCustomersInQueue(userId);
		request.setAttribute("queue",queue);

		return "queueManager";
	}
	
	/**
	 * M�todo respons�vel por chamar um cliente da fila.
	 * 
	 * @param request Request enviado pelo cliente
	 * @return P�gina de erro, caso ocorra algum.
	 * @return Interface da fila, caso o cliente tenha sido chamado com sucesso.
	 */	
	@RequestMapping(value = "/callCustomerFromQueue", method = RequestMethod.POST)
	public String callCustomerFromQueue(HttpServletRequest request)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		String inputId = request.getParameter("id");
		try
		{
			Integer id = Integer.parseInt(inputId);
			QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
			RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");

			try
			{
				CustomerInQueue customerInQueue = queuesDAO.selectByCustomerInQueueId(id);
				SMSBRService smsService = new SMSBRService();
				
				String mensagem = 		"SmartQueue informa: \n" + 
										customerInQueue.getCustomer_name() +
										", sua mesa para " +
										customerInQueue.getParty() +
										" pessoa(s) no restaurante " +
										restaurantDAO.selectById(customerInQueue.getRestaurant_id()).get(0).getName() +
										" ja esta disponivel.";	
				
				smsService.sendSMS("55"+customerInQueue.getTelephone(),mensagem);
				request.setAttribute("indexOfTheUserCalled",id);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			} catch (MessageSizeException e)
			{
				e.printStackTrace();
			} catch (ConnectionAuthenticationException e)
			{
				e.printStackTrace();
			} catch (NotEnoughCreditsException e)
			{
				e.printStackTrace();
			}
			
			return queueManager(request);
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Id de usu�rio escolhido para chamar inv�lido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
	}
	
	/**
	 * M�todo respons�vel por remover um cliente da fila.
	 * 
	 * @param request Request enviado pelo cliente
	 * @return P�gina de erro, caso ocorra algum.
	 * @return Interface da fila, caso o cliente tenha sido deletado com sucesso.
	 */	
	@RequestMapping(value = "/removeCustomerFromQueue", method = RequestMethod.POST)
	public String removeCustomerFromQueue(HttpServletRequest request)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		String inputId = request.getParameter("id");
		try
		{
			Integer id = Integer.parseInt(inputId);
			QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");

			try
			{;
				queuesDAO.deleteCustomerInQueue(id);
			}
			catch(EmptyResultDataAccessException emptyResultDataAccessException)
			{
				errorMessages.add("O usu�rio selecionado j� foi removido da fila");
				request.setAttribute("errorMessages",errorMessages);
				return "error";
			}
			
			return queueManager(request);
		}
		catch(NumberFormatException numberFormatException)
		{
			errorMessages.add("Id de usu�rio escolhido para remover inv�lido.");
			request.setAttribute("errorMessages",errorMessages);
			return "error";
		}
	}
	
	/**
	 * M�todo respons�vel por adicionar um cliente � fila.
	 * 
	 * 
	 * @param request Request enviado pelo cliente.
	 * @return P�gina de erro, caso ocorra algum.
	 * @return Interface da fila, caso o cliente tenha sido adicionado com sucesso.
	 */
	@RequestMapping(value = "/addUserToQueue", method = RequestMethod.POST)
	public String addUserToQueue(HttpServletRequest request)
	{	
		ArrayList<String> errorMessages = new ArrayList<String>();
		
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
				errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada m�ltipla de restaurantes</b>");
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
				CustomerInQueue customerToAdd = new CustomerInQueue(restaurantId,name,party,telephone,0);
				
				queuesDAO.create(customerToAdd);
	
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
		
		return queueManager(request);
	}
}

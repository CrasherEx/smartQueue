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
import com.omega.smartqueue.daos.RestaurantDAO;
import com.omega.smartqueue.enums.UserType;
import com.omega.smartqueue.model.Customer;
import com.omega.smartqueue.model.Restaurant;

/**
 * Controller responsável pela validação do login.
 * Se tudo correr bem, o usuário é reconhecido e passa a estar logado.
 * 
 * @see validators Package com as classes de validação
 */

@Controller
public class LoginController {
	
	/**
	 * @return Página de login, onde o usuário deverá preencher os campos de email e senha
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login/main";
	}
	
	/**
	 * Método responsável por deslogar o usuário.
	 * @param request Request enviado pelo cliente
	 * @return Pagina principal
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}
	
	/**
	 * Método responsável pela validação do campo de email e senha.
	 * @param request Request enviado pelo cliente
	 * @return Página principal, caso o login seja efetuado com sucesso.
	 * @return Página de login com erros sendo exibidos, caso algo de errado ocorra.
	 */
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
			return "login/main";
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("CustomerDAO");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		

		ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) restaurantDAO.selectByEmail(inputEmail);
		ArrayList<Customer> customerList = (ArrayList<Customer>) customerDAO.selectByEmail(inputEmail);
		
		if(customerList.size() == 0 && restaurantList.size() == 0)
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.add("<b>Usuário</b> inexistente.");
		}
		else if(customerList.size() == 1 && restaurantList.size() == 1)
		{
			request.setAttribute("inputEmailError",true);
			request.setAttribute("inputPasswordError",true);
			errorMessages.add("Um erro interno ocorreu. Contate o SAC imediatamente. <b>Erro:</b> Cliente e restaurantes com e-mail igual.");
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
		else if(restaurantList.size() == 1)
		{
			Restaurant restaurant = restaurantList.get(0);
			if(inputPassword.equals(restaurant.getPassword()) == false)
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
				session.setAttribute("userId",restaurant.getRestaurant_id());
				session.setAttribute("userType",UserType.RESTAURANT);
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
		return "login/main";
	}
	
}

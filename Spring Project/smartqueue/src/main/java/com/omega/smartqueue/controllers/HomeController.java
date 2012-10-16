package com.omega.smartqueue.controllers;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omega.smartqueue.daos.RestaurantDAO;
import com.omega.smartqueue.model.Restaurant;

@Controller
public class HomeController {

	@RequestMapping(value = {"/","home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		return "home";
	}
	
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
}

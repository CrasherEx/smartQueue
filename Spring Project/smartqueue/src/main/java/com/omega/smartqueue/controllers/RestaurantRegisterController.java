package com.omega.smartqueue.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omega.smartqueue.daos.CustomerDAO;
import com.omega.smartqueue.daos.RestaurantDAO;
import com.omega.smartqueue.model.Restaurant;
import com.omega.smartqueue.validators.AddressValidator;
import com.omega.smartqueue.validators.CityValidator;
import com.omega.smartqueue.validators.EmailValidator;
import com.omega.smartqueue.validators.NameValidator;
import com.omega.smartqueue.validators.PasswordValidator;
import com.omega.smartqueue.validators.StateValidator;
import com.omega.smartqueue.validators.TelephonePrefixValidator;
import com.omega.smartqueue.validators.TelephoneValidator;

@Controller
public class RestaurantRegisterController {
	
	@RequestMapping(value = "/restaurantRegister", method = RequestMethod.GET)
	public String register() {
		return "register/restaurant/main";
	}
	
	@RequestMapping(value = "/submitRestaurantRegister", method = RequestMethod.POST)
	public String submitRegister(HttpServletRequest request) {
	
		String inputName = request.getParameter("inputName");
		
		String inputEmail = request.getParameter("inputEmail");
		String confirmInputEmail = request.getParameter("confirmInputEmail");

		String inputPassword = request.getParameter("inputPassword");
		String confirmInputPassword = request.getParameter("confirmInputPassword");
		
		String inputTelephonePrefix = request.getParameter("inputTelephonePrefix");
		String inputTelephone = request.getParameter("inputTelephone");
	
		String inputAddress = request.getParameter("inputAddress");
		String inputState = request.getParameter("inputState");
		String inputCity = request.getParameter("inputCity");
		
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		NameValidator nameValidator = new NameValidator();
		ArrayList<String> nameValidatorErrors = nameValidator.validate(inputName);
		if(nameValidatorErrors.size() > 0)
		{
			request.setAttribute("inputNameError",true);
			errorMessages.addAll(nameValidatorErrors);
		}
		
		EmailValidator emailValidator = new EmailValidator();
		ArrayList<String> emailValidatorErrors = emailValidator.validate(inputEmail);
		if(emailValidatorErrors.size() > 0)
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.addAll(emailValidatorErrors);
		}
		else if(confirmInputEmail == null)
		{
			request.setAttribute("confirmInputEmailError",true);
			errorMessages.add("O campo <b>Confirmar E-Mail</b> não confere com o campo <b>E-mail</b>.");
		}
		else if(inputEmail.equals(confirmInputEmail) == false)
		{
			request.setAttribute("confirmInputEmailError",true);
			errorMessages.add("O campo <b>Confirmar E-Mail</b> não confere com o campo <b>E-mail</b>.");
		}

		PasswordValidator passwordValidator = new PasswordValidator();
		ArrayList<String> passwordValidatorErrors = passwordValidator.validate(inputPassword);
		if(passwordValidatorErrors.size() > 0)
		{
			request.setAttribute("inputPasswordError",true);
			errorMessages.addAll(passwordValidatorErrors);
		}
		else if(confirmInputPassword == null)
		{
			request.setAttribute("confirmInputPasswordError",true);
			errorMessages.add("O campo <b>Confirmar Senha</b> não confere com o campo <b>Senha</b>.");
		}
		else if(inputPassword.equals(confirmInputPassword) == false)
		{
			request.setAttribute("confirmInputPasswordError",true);
			errorMessages.add("O campo <b>Confirmar Senha</b> não confere com o campo <b>Senha</b>.");
		}
		
		TelephonePrefixValidator telephonePrefixValidator = new TelephonePrefixValidator();
		TelephoneValidator telephoneValidator = new TelephoneValidator();
		ArrayList<String> telephonePrefixValidatorErrors = telephonePrefixValidator.validate(inputTelephonePrefix);
		ArrayList<String> telephoneValidatorErrors = telephoneValidator.validate(inputTelephone);
		if(telephoneValidatorErrors.size() > 0 || telephonePrefixValidatorErrors.size() > 0)
		{
			request.setAttribute("inputTelephoneError",true);
			errorMessages.addAll(telephonePrefixValidatorErrors);
			errorMessages.addAll(telephoneValidatorErrors);
		}
		
		AddressValidator addressValidator = new AddressValidator();
		ArrayList<String> addressValidatorErrors = addressValidator.validate(inputAddress);
		if(addressValidatorErrors.size() > 0)
		{
			request.setAttribute("inputAddressError",true);
			errorMessages.addAll(addressValidatorErrors);
		}

		StateValidator stateValidator = new StateValidator();
		ArrayList<String> stateValidatorErrors = stateValidator.validate(inputState);
		if(stateValidatorErrors.size() > 0)
		{
			request.setAttribute("inputStateError",true);
			errorMessages.addAll(stateValidatorErrors);
		}

		CityValidator cityValidator = new CityValidator();
		ArrayList<String> cityValidatorErrors = cityValidator.validate(inputCity);
		if(cityValidatorErrors.size() > 0)
		{
			request.setAttribute("inputCityError",true);
			errorMessages.addAll(cityValidatorErrors);
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		
		if(restaurantDAO.selectByEmail(inputEmail).size()>0)
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.add("Já existe um restaurante com esse e-mail registrado.");	
		}
		
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("CustomerDAO");
		
		if(customerDAO.selectByEmail(inputEmail).size()>0)
		{
			request.setAttribute("inputEmailError",true);
			errorMessages.add("Já existe um usuário com esse e-mail registrado.");	
		}
		
		if(errorMessages.size() > 0)
		{
			request.setAttribute("errorMessages",errorMessages);
			return "register/restaurant/main";
		}
		else
		{
			String telephone = inputTelephonePrefix+inputTelephone;

			Restaurant restaurantToCreate = new Restaurant(	inputName,
															inputEmail,
															inputPassword,
															telephone,
															inputState,
															inputCity,
															inputAddress);
			restaurantDAO.create(restaurantToCreate);
			return "register/restaurant/success";
		}

	}
	
	@RequestMapping(value = "/showRestaurants", method = RequestMethod.GET)
	public String showUsers(HttpServletRequest request)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
		ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantDAO.selectAll();
		request.setAttribute("restaurants",restaurants);
		return "showRestaurants";
	}
	
}

package com.omega.smartqueue.controllers;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omega.smartqueue.daos.LoginInformationDAO;
import com.omega.smartqueue.model.LoginInformation;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/submitRegister", method = RequestMethod.POST)
	public String submitRegister(
								@RequestParam("inputName") String inputName, 
								@RequestParam("inputLastName") String inputLastName,

								@RequestParam("inputDayOfBirth") String inputDayOfBirth,
								@RequestParam("inputMonthOfBirth") String inputMonthOfBirth,
								@RequestParam("inputYearOfBirth") String inputYearOfBirth,
								
								@RequestParam("inputGender") String inputGender,
								
								@RequestParam("inputEmail") String inputEmail, 
								@RequestParam("confirmInputEmail") String confirmInputEmail, 

								@RequestParam("inputPassword") String inputPassword,
								@RequestParam("confirmInputPassword") String confirmInputPassword,
								
								@RequestParam("inputTelephonePrefix") String inputTelephonePrefix,
								@RequestParam("inputTelephone") String inputTelephone,
							
								@RequestParam("inputAddress") String inputAddress,
								@RequestParam("inputState") String inputState,
								@RequestParam("inputCity") String inputCity

								) {
		
		boolean isThereAnError = false;
		ArrayList<String> errorMessages = new ArrayList<String>();
		int integerInputDayOfBirth;
		int integerInputMonthOfBirth;
		int integerInputYearOfBirth;
		
		if(inputDayOfBirth == "none" || inputMonthOfBirth == "none" || inputYearOfBirth == "none")
		{
			isThereAnError = true;
			errorMessages.add("A data de nascimento não está preenchida totalmente.");
		}
		else{
			try
			{
				integerInputDayOfBirth = Integer.parseInt(inputDayOfBirth);
				integerInputMonthOfBirth = Integer.parseInt(inputMonthOfBirth);
				integerInputYearOfBirth = Integer.parseInt(inputYearOfBirth);

				// Falta alterar o codigo para não aceitar combinações como 30 de Fevereiro (que não existe)
				if(integerInputDayOfBirth < 1 || integerInputDayOfBirth > 31)
				{
					isThereAnError = true;
					errorMessages.add("O dia de nascimento necessita estar entre 1 e 31, inclusive.");
				}
				if(integerInputMonthOfBirth < 1 || integerInputMonthOfBirth > 12)
				{
					isThereAnError = true;
					errorMessages.add("O mês de nascimento necessita estar entre 1 e 12, inclusive.");
				}
				if(integerInputYearOfBirth < 1900 || integerInputYearOfBirth > 2012)
				{
					isThereAnError = true;
					errorMessages.add("O ano de nascimento necessita estar entre 1900 e 2012, inclusive.");
				}
			}
			catch(NumberFormatException numberFormatException)
			{
				isThereAnError = true;
				errorMessages.add("Os valores da data de nascimento necessitam ser números inteiros.");
			}
		}
		
		if(inputGender == "none")
		{
			isThereAnError = true;
			errorMessages.add("O campo de gênero necessita ser preenchido.");
		}
		else
		{
			if(inputGender != "male" && inputGender != "female")
			{
				isThereAnError = true;
				errorMessages.add("Valores para gênero invalidos");
			}
		}
		
		// Falta checar se o email é um email válido a@a.com
		if(inputEmail.equals(""))
		{
			isThereAnError = true;
			errorMessages.add("O campo email necessita ser preenchido.");
		}
		else
		{
			if(inputEmail.equals(confirmInputEmail) == false)
			{
				isThereAnError = true;
				errorMessages.add("O email digitado não está igual à confirmação de email.");
			}
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
		LoginInformationDAO loginInformationDAO = (LoginInformationDAO) context.getBean("loginInformationDAO");
	//	LoginInformation loginInformation = new LoginInformation(username,password);
		//loginInformationDAO.create(loginInformation);

		return "register";
	}
	
}

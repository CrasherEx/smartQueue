package com.omega.smartqueue.model;

import org.apache.commons.mail.*;

public class EmailSender
{
	private final String HOST_NAME = "smtp.gmail.com";
	private final String AUTHENTICATION_LOGIN = "smartqueueapp";
	private final String AUTHENTICATION_PASSWORD = "0m3g4+1ftw";
	private final String SUBJECT = "Email de confirmacao de cadastro";
	private final String FROM = "smartqueueapp@gmail.com";
	private final boolean DEBUG = true;
	private final boolean SSL = true;
	private String to;
	private String message;
	SimpleEmail simpleEmail = new SimpleEmail();
	
	public EmailSender(Customer customer)
	{
		to = customer.getEmail();
		message = "Estamos enviando esse email no intuito de confirmar o seu cadastro\n" +
		"Seu login :" + customer.getEmail() + "\n" +
		"Sua senha :" + customer.getPassword() + "\n\n" +
		"Caso deseje modificar alguma informação pessoal, visite nosso site.";
	}
	
	public EmailSender(Restaurant restaurant)
	{
		to = restaurant.getEmail();
		message = "Estamos enviando esse email no intuito de confirmar o seu cadastro\n" +
		"Seu login :" + restaurant.getEmail() + "\n" +
		"Sua senha :" + restaurant.getPassword() + "\n\n" +
		"Caso deseje modificar alguma informação pessoal, visite nosso site.";
	}
	
	public void sendEmail()
	{
		try
		{
			simpleEmail.setDebug(DEBUG);
			simpleEmail.setHostName(HOST_NAME);
			simpleEmail.setAuthentication(AUTHENTICATION_LOGIN,AUTHENTICATION_PASSWORD);
			simpleEmail.setSSL(SSL);
			simpleEmail.addTo(to);
			simpleEmail.setFrom(FROM);
			simpleEmail.setSubject(SUBJECT);
			simpleEmail.setMsg(message);
			simpleEmail.send();
		}
		catch(EmailException emailException)
		{
			emailException.printStackTrace();
		}
	}
}

package com.omega.smartqueue.model;

import java.sql.Date;

import com.omega.smartqueue.enums.Gender;

/**
 * Classe que representa o cliente na aplicação.
 * Nela consta todos os dados cadastrais do clientes, que devem ser
 * fornecidos durante o cadastro.
 */

public class Customer
{
	/**
	 * O ID do cliente no banco de dados
	 */
	int customer_id;
	/**
	 * O primeiro nome do cliente no banco de dados
	 */
	String name;
	/**
	 * O último nome do cliente no banco de dados
	 */
	String lastName;
	/**
	 * O email do cliente no banco de dados
	 */
	String email;
	/**
	 * A senha do cliente no banco de dados
	 */
	String password;
	/**
	 * O telefone do cliente no banco de dados
	 */
	String telephone;
	/**
	 * O gênero do cliente no banco de dados
	 */
	Gender gender;
	/**
	 * A data de nascimento do cliente no banco de dados
	 */
	Date dateOfBirth;
	/**
	 * O estado do cliente no banco de dados
	 */
	String state;
	/**
	 * A cidade do cliente no banco de dados
	 */
	String city;
	/**
	 * O endereço do cliente no banco de dados
	 */
	String address;
	
	
	public int getCustomer_id()
	{
		return customer_id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getTelephone()
	{
		return telephone;
	}
	
	public Gender getGender()
	{
		return gender;
	}
	
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	public String getState()
	{
		return state;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public Customer(int customer_id, String name, String lastName,
			String email, String password, String telephone, Gender gender,
			Date dateOfBirth, String state, String city, String address)
	{
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.state = state;
		this.city = city;
		this.address = address;
	}
	
	public Customer(String name, String lastName,
			String email, String password, String telephone, Gender gender,
			Date dateOfBirth, String state, String city, String address)
	{
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.state = state;
		this.city = city;
		this.address = address;
	}
}

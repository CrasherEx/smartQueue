package com.omega.smartqueue.model;

/**
 * Classe que representa o restaurante na aplica��o.
 * Nela consta todos os dados cadastrais do restaurante, que devem ser
 * fornecidos durante o cadastro.
 */

public class Restaurant
{
	/**
	 * O ID do restaurante
	 */
	int restaurant_id;
	/**
	 * Nome do restaurante
	 */
	String name;
	/**
	 * Email do restaurante
	 */
	String email;
	/**
	 * Senha do restaurante
	 */
	String password;
	/**
	 * Telefone do restaurante
	 */
	String telephone;
	/**
	 * Estado do restaurante
	 */
	String state;
	/**
	 * Cidade do restaurante
	 */
	String city;
	/**
	 * Endere�o do restaurante
	 */
	String address;
	/**
	 * Fila do restaurante
	 */
	Queue queue = new Queue();
	
	public int getRestaurant_id() 
	{
		return restaurant_id;
	}
	public String getName() 
	{
		return name;
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
	
	public Restaurant(	int restaurant_id,
						String name, 
						String email,
						String password, 
						String telephone,
						String state, 
						String city,
						String address)
	{
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.state = state;
		this.city = city;
		this.address = address;
	}
	
	public Restaurant(	String name, 
						String email,
						String password, 
						String telephone,
						String state, 
						String city,
						String address )
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.state = state;
		this.city = city;
		this.address = address;
	}
}

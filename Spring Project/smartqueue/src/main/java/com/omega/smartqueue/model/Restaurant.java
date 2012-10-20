package com.omega.smartqueue.model;

public class Restaurant
{
	int restaurant_id;
	String name;
	String email;
	String password;
	String telephone;
	String state;
	String city;
	String address;
	Queue queue = new Queue();
	
	// CookType cookType;
	// Número de mesas / pessoas?
	// Horário de Funcionamento?
	// Cardápio? Será uma imagem.. mas onde ficará salva?
	
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

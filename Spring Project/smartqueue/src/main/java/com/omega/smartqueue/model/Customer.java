package com.omega.smartqueue.model;

import com.omega.smartqueue.enums.Gender;

public class Customer
{
	int customer_id;
	String name;
	String lastName;
	String email;
	String password;
	String telephone;
	Gender gender;
	String dateOfBirth;
	String state;
	String city;
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
	public String getDateOfBirth()
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
			String dateOfBirth, String state, String city, String address)
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
	
	
}

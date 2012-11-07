package com.omega.smartqueue.model;

import java.sql.Date;

import com.omega.smartqueue.enums.Gender;
/**
 * @author Aluno5
 */
public class Customer
{
	/**
	 * The customer's id in the MySQL database
	 */
	int customer_id;
	/**
	 * The customer's first name in the MySQL database 
	 */
	String name;
	/**
	 * The customer's last name in the MySQL database
	 */
	String lastName;
	/**
	 * The customer's email in MySQL database
	 */
	String email;
	/**
	 * The customer's password in MySQL database
	 */
	String password;
	/**
	 * The customer's telephone in MySQL database
	 */
	String telephone;
	/**
	 * The customer's gender in MySQL database
	 */
	Gender gender;
	/**
	 * The customer's date of birth in MySQL database
	 */
	Date dateOfBirth;
	/**
	 * The customer's state in MySQL database
	 */
	String state;
	/**
	 * The customer's city in MySQL database
	 */
	String city;
	/**
	 * The customer's address in MySQL database
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

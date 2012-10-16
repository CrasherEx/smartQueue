package com.omega.smartqueue.model;

public class CustomerInQueue
{
	int customer_in_queue_id;
	int restaurant_id;
	String customer_name;
	int party;
	int position;
	int telephone;
	int customer_id;
	
	public CustomerInQueue(int customer_in_queue_id, int restaurant_id,
			String customer_name, int party, int position, int telephone,
			int customer_id)
	{
		super();
		this.customer_in_queue_id = customer_in_queue_id;
		this.restaurant_id = restaurant_id;
		this.customer_name = customer_name;
		this.party = party;
		this.position = position;
		this.telephone = telephone;
		this.customer_id = customer_id;
	}

	public CustomerInQueue(int restaurant_id,
			String customer_name, int party, int telephone,
			int customer_id)
	{
		super();
		this.restaurant_id = restaurant_id;
		this.customer_name = customer_name;
		this.party = party;
		this.position = position;
		this.telephone = telephone;
		this.customer_id = customer_id;
	}

	public int getCustomer_in_queue_id()
	{
		return customer_in_queue_id;
	}

	public void setCustomer_in_queue_id(int customer_in_queue_id)
	{
		this.customer_in_queue_id = customer_in_queue_id;
	}

	public int getRestaurant_id()
	{
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id)
	{
		this.restaurant_id = restaurant_id;
	}

	public String getCustomer_name()
	{
		return customer_name;
	}

	public void setCustomer_name(String customer_name)
	{
		this.customer_name = customer_name;
	}

	public int getParty()
	{
		return party;
	}

	public void setParty(int party)
	{
		this.party = party;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public int getTelephone()
	{
		return telephone;
	}

	public void setTelephone(int telephone)
	{
		this.telephone = telephone;
	}

	public int getCustomer_id()
	{
		return customer_id;
	}

	public void setCustomer_id(int customer_id)
	{
		this.customer_id = customer_id;
	}
}

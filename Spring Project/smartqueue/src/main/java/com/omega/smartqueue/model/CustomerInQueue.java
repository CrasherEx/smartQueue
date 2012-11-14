package com.omega.smartqueue.model;

/**
 * Classe que representa o cliente na fila.
 * Nela consta todos os dados do cliente na fila de um restaurante
 */

public class CustomerInQueue
{
	/**
	 * O id do cliente na fila
	 */
	int customer_in_queue_id;
	/**
	 * O ID do restaurante ao qual o cliente pertence
	 */
	int restaurant_id;
	/**
	 * O nome do cliente na fila
	 */
	String customer_name;
	/**
	 * O total de pessoas que compõem o grupo do cliente
	 */
	int party;
	/**
	 * A posição do cliente na fila
	 */
	int position;
	/**
	 * O telefone do cliente na fila
	 */
	String telephone;
	/**
	 * O ID do cliente na fila
	 */
	int customer_id;
	
	public CustomerInQueue(int customer_in_queue_id, int restaurant_id,
			String customer_name, int party, int position, String telephone,
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
			String customer_name, int party, String telephone,
			int customer_id)
	{
		super();
		this.restaurant_id = restaurant_id;
		this.customer_name = customer_name;
		this.party = party;
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

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
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

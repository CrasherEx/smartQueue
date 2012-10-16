package com.omega.smartqueue.model;

import java.util.List;

public class Queue
{

	private List<Customer> queue;

	public Queue()
	{
	}

	/**
	 * Adds someone in the queue.
	 * 
	 * @param customer
	 *            the customer to be added.
	 */
	public void addCustomer(Customer customer)
	{
		queue.add(customer);
	}

	/**
	 * Deletes someone in the queue.
	 * 
	 * @param customer
	 *            the customer to be deleted.
	 */
	public void deleteCustomer(Customer customer)
	{
		queue.remove(customer);
	}

	/**
	 * Returns how many people are in the queue.
	 * 
	 * @return how many objects are in the queue.
	 */
	public int getSize()
	{
		return queue.size();
	}

	/**
	 * Returns how many people are in front of someone.
	 * 
	 * @param customer
	 * @return customer's position in queue.
	 */
	public int getPosition(Customer customer)
	{
		return queue.indexOf(customer);
	}

	/**
	 * Allows someone to update the queue, removing the first person.
	 * 
	 */
	public void update()
	{
		queue.remove(0);
	}
}

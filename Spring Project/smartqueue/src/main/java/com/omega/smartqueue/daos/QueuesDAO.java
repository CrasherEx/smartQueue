package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.CustomerInQueue;

public interface QueuesDAO 
{
	public void create(CustomerInQueue customerInQueue);
	public List<CustomerInQueue> selectCustomersInQueue(int restaurant_id);
	public void deleteCustomerInQueue(int customer_in_queue_id);
	public CustomerInQueue selectByCustomerId(int customer_id);
}

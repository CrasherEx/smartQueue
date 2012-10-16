package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.Customer;

public interface CustomerDAO 
{
	public void create(Customer customer);
	public List<Customer> selectByEmail(String email);
	public List<Customer> selectById(int id);
	public List<Customer> selectAll();
}

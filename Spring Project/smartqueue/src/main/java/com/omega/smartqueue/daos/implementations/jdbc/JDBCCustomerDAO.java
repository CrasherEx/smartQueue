package com.omega.smartqueue.daos.implementations.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.omega.smartqueue.daos.CustomerDAO;
import com.omega.smartqueue.daos.implementations.jdbc.rowmappers.CustomerRowMapper;
import com.omega.smartqueue.model.Customer;

public class JDBCCustomerDAO implements CustomerDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void create(Customer customer)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update("INSERT INTO customers (name,last_name,email,password,telephone,gender,date_of_birth,state,city,address) VALUES(?,?)",
	    		new Object[] { customer.getName(), customer.getLastName(), customer.getEmail(), customer.getPassword(), customer.getTelephone(), 
	    		customer.getGender().toString(), customer.getDateOfBirth(), customer.getCity(), customer.getAddress() });
	}
	
	public List<Customer> selectByEmail(String email)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate
	    	.query("SELECT * FROM customers WHERE email = ?",
	            new Object[] { email },
	            new CustomerRowMapper());
	}
}

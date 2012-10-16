package com.omega.smartqueue.daos.implementations.jdbc;

import java.sql.Types;
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
		String sql = "INSERT INTO customers (name,last_name,email,password,telephone,gender,date_of_birth,state,city,address) VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] values = { customer.getName(), 
							customer.getLastName(), 
							customer.getEmail(), 
							customer.getPassword(), 
							customer.getTelephone(), 
							customer.getGender().toString(), 
							customer.getDateOfBirth(), 
							customer.getState(), 
							customer.getCity(),
							customer.getAddress()
							};
		int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.CHAR,Types.DATE,Types.CHAR,Types.VARCHAR,Types.VARCHAR};
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql,values,types);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> selectByEmail(String email)
	{
		String sql = "SELECT * FROM customers WHERE email = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] { email },new CustomerRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> selectById(int id)
	{
		String sql = "SELECT * FROM customers WHERE customer_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] { id },new CustomerRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Customer> selectAll()
	{
		String sql = "SELECT * FROM customers";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] {},new CustomerRowMapper());
	}
}

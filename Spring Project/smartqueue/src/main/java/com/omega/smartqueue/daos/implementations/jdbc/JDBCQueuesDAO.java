package com.omega.smartqueue.daos.implementations.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.omega.smartqueue.daos.QueuesDAO;
import com.omega.smartqueue.daos.implementations.jdbc.rowmappers.QueuesRowMapper;
import com.omega.smartqueue.model.CustomerInQueue;

public class JDBCQueuesDAO implements QueuesDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	private int getLastPosition(int restaurant_id)
	{
		String sql = "SELECT MAX(position) FROM queues WHERE restaurant_id = ?";
		Object[] values = { restaurant_id };
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(sql,values);
	}
	
	public void create(CustomerInQueue customerInQueue)
	{
		int position;
		position = getLastPosition(customerInQueue.getRestaurant_id()) + 1;
		String sql = "INSERT INTO queues (restaurant_id,customer_name,party,position,telephone,customer_id) VALUES(?,?,?,?,?,?)";
		Object[] values = { customerInQueue.getRestaurant_id(), 
							customerInQueue.getCustomer_name(),  
							customerInQueue.getParty(),
							position,
							customerInQueue.getTelephone(),
							customerInQueue.getCustomer_id()
							};
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql,values);
	}

	@SuppressWarnings("unchecked")
	public List<CustomerInQueue> selectCustomersInQueue(int restaurant_id)
	{
		String sql = "SELECT * FROM queues WHERE restaurant_id = ? ORDER BY position";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] { restaurant_id },new QueuesRowMapper());
	}

	private CustomerInQueue selectByCustomerInQueueId(int customer_in_queue_id)
	{
		String sql = "SELECT * FROM queues WHERE customer_in_queue_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return (CustomerInQueue) jdbcTemplate.queryForObject(sql,new Object[] { customer_in_queue_id },new QueuesRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	private List<CustomerInQueue> selectCustomersInQueueWithPositionsHigherThan(int restaurant_id, int position)
	{
		String sql = "SELECT * FROM queues WHERE restaurant_id = ? AND position > ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] { restaurant_id, position },new QueuesRowMapper());
	}
	
	private void updatePosition(int customer_id, int position)
	{
		String sql = "UPDATE queues SET position = ? WHERE customer_id = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[] { position, customer_id });
	}
	
	public void deleteCustomerInQueue(int customer_in_queue_id)
	{
		CustomerInQueue customerBeingDeleted = selectByCustomerInQueueId(customer_in_queue_id);
		
		ArrayList<CustomerInQueue> customersToChangePosition = (ArrayList<CustomerInQueue>) selectCustomersInQueueWithPositionsHigherThan(customerBeingDeleted.getRestaurant_id(),customerBeingDeleted.getPosition());
		
		for(CustomerInQueue customerToChangePosition: customersToChangePosition)
		{
			updatePosition(customerToChangePosition.getCustomer_id(),customerToChangePosition.getPosition() - 1);
		}
		
		String sql = "DELETE FROM queues WHERE customer_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[] { customerBeingDeleted.getCustomer_id() });
		
	}

	public CustomerInQueue selectByCustomerId(int customer_id)
	{
		String sql = "SELECT * FROM queues WHERE customer_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return (CustomerInQueue) jdbcTemplate.queryForObject(sql,new Object[] { customer_id },new QueuesRowMapper());
	}
}

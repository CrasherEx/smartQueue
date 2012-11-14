package com.omega.smartqueue.daos.implementations.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.omega.smartqueue.daos.QueuesDAO;
import com.omega.smartqueue.daos.implementations.jdbc.rowmappers.QueuesRowMapper;
import com.omega.smartqueue.model.CustomerInQueue;

/**
 * O JDBC é responsável por unir Java e MySQL.
 * No caso em questão, a classe fará as conexões entre a entidade Queue
 * e a entidade do banco de dados, utilizando a interface QueuesDAO.
 * 
 * @see daos Package com as principais interfaces da aplicação
 * @see resultextractors Package com as classes responsáveis por transformar as colunas
 * do banco de dados em uma Class de java.
 * @see rowmappers Package com as classes responsáveis por mapear as colunas do banco de dados
 */

public class JDBCQueuesDAO implements QueuesDAO
{
	/**
	 * Características de acesso ao banco de dados
	 * (e.g. username, password)
	 */
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
	
	/**
	 * Este método é responsável por criar um novo CustomerInQueue
	 * e assimilá-lo a uma fila.
	 * @param customerInQueue Customer que será criado e assimilado em uma fila
	 */
	public void create(CustomerInQueue customerInQueue)
	{
		int position;
		position = getLastPosition(customerInQueue.getRestaurant_id()) + 1;
		String sql;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		if(customerInQueue.getCustomer_id() == 0)
		{
			sql = "INSERT INTO queues (restaurant_id,customer_name,party,position,telephone,customer_id) VALUES(?,?,?,?,?,NULL)";

			Object[] values = { customerInQueue.getRestaurant_id(), 
								customerInQueue.getCustomer_name(),  
								customerInQueue.getParty(),
								position,
								customerInQueue.getTelephone(),
								};
		    jdbcTemplate.update(sql,values);
		}
		else
		{
			sql = "INSERT INTO queues (restaurant_id,customer_name,party,position,telephone,customer_id) VALUES(?,?,?,?,?,?)";
			Object[] values = { customerInQueue.getRestaurant_id(), 
								customerInQueue.getCustomer_name(),  
								customerInQueue.getParty(),
								position,
								customerInQueue.getTelephone(),
								customerInQueue.getCustomer_id()
								};
		    jdbcTemplate.update(sql,values);
		}
	}
	
	/**
	 * Método que busca um restaurante através do seu ID
	 * e seleciona todos os clientes em sua fila.
	 * 
	 * @param restaurant_id ID do restaurante que será utilizado para a query
	 * @return Lista de clientes na fila do restaurante
	 */
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
	
	private void updatePosition(int customer_in_queue_id, int position)
	{
		String sql = "UPDATE queues SET position = ? WHERE customer_in_queue_id = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[] { position, customer_in_queue_id });
	}
	
	/**
	 * Este método deleta um cliente da fila.
	 * 
	 * @param customer_in_queue_id Id do cliente que deve ser deletado da fila.
	 */
	public void deleteCustomerInQueue(int customer_in_queue_id)
	{
		CustomerInQueue customerBeingDeleted = selectByCustomerInQueueId(customer_in_queue_id);
		
		ArrayList<CustomerInQueue> customersToChangePosition = (ArrayList<CustomerInQueue>) selectCustomersInQueueWithPositionsHigherThan(customerBeingDeleted.getRestaurant_id(),customerBeingDeleted.getPosition());
		
		for(CustomerInQueue customerToChangePosition: customersToChangePosition)
		{
			updatePosition(customerToChangePosition.getCustomer_in_queue_id(),customerToChangePosition.getPosition() - 1);
		}
		
		String sql = "DELETE FROM queues WHERE customer_in_queue_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[] { customerBeingDeleted.getCustomer_in_queue_id() });
		
	}
	
	/**
	 * Este método faz uma query no banco de dados e seleciona um
	 * CustomerInQueue através do seu ID.
	 * @param customer_id ID do CustomerInQueue que será utilizado na realização da query
	 * @return O CustomerInQueue correspondente ao ID passado como parâmetro
	 */
	public CustomerInQueue selectByCustomerId(int customer_id)
	{
		String sql = "SELECT * FROM queues WHERE customer_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return (CustomerInQueue) jdbcTemplate.queryForObject(sql,new Object[] { customer_id },new QueuesRowMapper());
	}
}

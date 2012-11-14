package com.omega.smartqueue.daos.implementations.jdbc;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.omega.smartqueue.daos.CustomerDAO;
import com.omega.smartqueue.daos.implementations.jdbc.rowmappers.CustomerRowMapper;
import com.omega.smartqueue.model.Customer;

/**
 * O JDBC � respons�vel por unir Java e MySQL.
 * No caso em quest�o, a classe far� as conex�es entre a entidade Customer
 * e a entidade do banco de dados, utilizando a interface CustomerDAO.
 * 
 * @see daos Package com as principais interfaces da aplica��o
 * @see resultextractors Package com as classes respons�veis por transformar as colunas
 * do banco de dados em uma Class de java.
 * @see rowmappers Package com as classes respons�veis por mapear as colunas do banco de dados
 */

public class JDBCCustomerDAO implements CustomerDAO
{
	/**
	 * Caracter�sticas de acesso ao banco de dados
	 * (e.g. username, password)
	 */
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	/**
	 * Este m�todo adicionar� um novo cliente ao banco de dados.
	 * @param customer Customer que ser� adicionado ao banco de dados.
	 */
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
	
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os usu�rios
	 * que possuirem o email correspondente ao do par�metro.
	 * 
	 * @param email Email do cliente, que ser� utilizado para uma query no banco de dados
	 * @return Lista de clientes com o email em quest�o
	 */	
	@SuppressWarnings("unchecked")
	public List<Customer> selectByEmail(String email)
	{
		String sql = "SELECT * FROM customers WHERE email = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] { email },new CustomerRowMapper());
	}
	
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os usu�rios
	 * que possuirem o ID correspondente ao do par�metro.
	 * @param id ID do cliente, que ser� utilizado para uma query no banco de dados
	 * @return Lista de clientes com o ID em quest�o
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> selectById(int id)
	{
		String sql = "SELECT * FROM customers WHERE customer_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] { id },new CustomerRowMapper());
	}
	
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os clientes existentes.
	 * @return Lista de clientes registrados no banco de dados.
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> selectAll()
	{
		String sql = "SELECT * FROM customers";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql,new Object[] {},new CustomerRowMapper());
	}
}

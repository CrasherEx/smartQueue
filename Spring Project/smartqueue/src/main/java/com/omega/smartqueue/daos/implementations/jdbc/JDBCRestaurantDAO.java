/**
 * 
 */
package com.omega.smartqueue.daos.implementations.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.omega.smartqueue.daos.RestaurantDAO;
import com.omega.smartqueue.daos.implementations.jdbc.rowmappers.RestaurantRowMapper;
import com.omega.smartqueue.model.Restaurant;

/**
 * O JDBC é responsável por unir Java e MySQL.
 * No caso em questão, a classe fará as conexões entre a entidade Restaurant
 * e a entidade do banco de dados, utilizando a interface RestaurntDAO.
 * 
 * @see daos Package com as principais interfaces da aplicação
 * @see resultextractors Package com as classes responsáveis por transformar as colunas
 * do banco de dados em uma Class de java.
 * @see rowmappers Package com as classes responsáveis por mapear as colunas do banco de dados
 */

public class JDBCRestaurantDAO implements RestaurantDAO
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
	
	/**
	 * Este método é responsável por adicionar um novo restaurante ao banco de dados.
	 * 
	 * @param restaurant Restaurante que será adicionado ao banco de dados
	 */
	public void create(Restaurant restaurant)
	{
		String sql = "INSERT INTO restaurants (name,email,password,telephone,state,city,address) VALUES(?,?,?,?,?,?,?)";
		Object[] values = { restaurant.getName(),
							restaurant.getEmail(),
							restaurant.getPassword(),
							restaurant.getTelephone(),
							restaurant.getState(),
							restaurant.getCity(),
							restaurant.getAddress()
							};
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sql,values);
	}
	
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo email é compatível com o do parâmetro.
	 * 
	 * @param email Email utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o email compatível com o do parâmetro
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectByEmail(String email)
	{
		String sql = "SELECT * FROM restaurants WHERE email = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { email }, new RestaurantRowMapper());
	}
	
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo nome é compatível com o do parâmetro.
	 * 
	 * @param name Nome utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o nome compatível com o do parâmetro
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectByName(String name)
	{
		String sql = "SELECT * FROM restaurants WHERE name = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { name }, new RestaurantRowMapper());
	}
	
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo ID é compatível com o do parâmetro.
	 * 
	 * @param restaurant_id ID utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o ID compatível com o do parâmetro
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectById(int restaurant_id)
	{
		String sql = "SELECT * FROM restaurants WHERE restaurant_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { restaurant_id }, new RestaurantRowMapper());
	}
	
	/**
	 * Este método utiliza a string "nameSearch" para realizar uma query no banco de dados,
	 * de modo que se um restaurante possuir em seu nome o valor da string, ainda que
	 * este não seja o nome do restaurante, o restaurante será um dos valores de
	 * retorno presente na lista.
	 * (e.g. nameSearch = "back", Outback é um valor de retorno.)
	 * 
	 * @param nameSearch String utilizada para query no banco de dados em busca
	 * de um nome de restaurante que inclua o valor da String.
	 * @return Lista de restaurantes que satisfazem a busca.
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectByNameSearch(String nameSearch)
	{
		nameSearch = "%" + nameSearch + "%";
		String sql = "SELECT * FROM restaurants WHERE name LIKE ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { nameSearch }, new RestaurantRowMapper());
	}
	
	/**
	 * Este método seleciona todos os restaurantes registrados no banco de dados
	 * 
	 * @return Lista de restaurantes registrados no banco de dados
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectAll()
	{
		String sql = "SELECT * FROM restaurants";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { }, new RestaurantRowMapper());
	}
	
}

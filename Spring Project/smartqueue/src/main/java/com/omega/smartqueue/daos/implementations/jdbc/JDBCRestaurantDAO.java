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
 * @author Luccas
 *
 */
public class JDBCRestaurantDAO implements RestaurantDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
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

	@SuppressWarnings("unchecked")
	public List<Restaurant> selectByEmail(String email)
	{
		String sql = "SELECT * FROM restaurants WHERE email = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { email }, new RestaurantRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectByName(String name)
	{
		String sql = "SELECT * FROM restaurants WHERE name = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { name }, new RestaurantRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectByNameSearch(String nameSearch)
	{
		nameSearch = "%" + nameSearch + "%";
		String sql = "SELECT * FROM restaurants WHERE name LIKE ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { nameSearch }, new RestaurantRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> selectAll()
	{
		String sql = "SELECT * FROM restaurants";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new Object[] { }, new RestaurantRowMapper());
	}
	
}

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
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update("INSERT INTO restaurants (name,email,password,telephone,state,city,address) VALUES(?,?)",
	    		new Object[] { restaurant.getName(), restaurant.getEmail(), restaurant.getPassword(), restaurant.getTelephone(), 
	    		restaurant.getCity(), restaurant.getAddress() });
	}
	
	public List<Restaurant> selectByName(String name)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate
	    	.query("SELECT * FROM restaurants WHERE name = ?",
	            new Object[] { name },
	            new RestaurantRowMapper());
	}
	
	public List<Restaurant> selectByFoodType(String foodType)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate
	    	.query("SELECT * FROM restaurants WHERE name = ?",
	            new Object[] { foodType },
	            new RestaurantRowMapper());
	}
	
}

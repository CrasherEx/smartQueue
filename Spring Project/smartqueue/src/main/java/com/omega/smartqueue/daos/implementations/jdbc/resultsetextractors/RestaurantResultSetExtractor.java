/**
 * 
 */
package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.model.Restaurant;

/**
 * @author Luccas
 *
 */
public class RestaurantResultSetExtractor implements ResultSetExtractor
{
	public Object extractData(ResultSet resultSet) throws SQLException
	{
		Restaurant restaurant = new Restaurant(resultSet.getInt("restaurant_id"),
				resultSet.getString("name"),
				resultSet.getString("email"),
				resultSet.getString("password"),
				resultSet.getString("telephone"),
				resultSet.getString("state"),
				resultSet.getString("city"),
				resultSet.getString("adress"));

		return restaurant;
	}
}

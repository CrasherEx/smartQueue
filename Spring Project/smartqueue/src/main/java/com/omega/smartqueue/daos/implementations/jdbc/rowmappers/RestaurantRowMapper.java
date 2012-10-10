/**
 * 
 */
package com.omega.smartqueue.daos.implementations.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors.RestaurantResultSetExtractor;

/**
 * @author Luccas
 *
 */
public class RestaurantRowMapper implements RowMapper
{
	public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
	{
		RestaurantResultSetExtractor extractor = new RestaurantResultSetExtractor();
		return extractor.extractData(resultSet);
	}
}

package com.omega.smartqueue.daos.implementations.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors.CustomerResultSetExtractor;

public class CustomerRowMapper implements RowMapper
{

	public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
	{
		CustomerResultSetExtractor extractor = new CustomerResultSetExtractor();
		return extractor.extractData(resultSet);
	}

}
package com.omega.smartqueue.daos.implementations.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors.QueuesResultSetExtractor;

public class QueuesRowMapper implements RowMapper
{

	public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
	{
		QueuesResultSetExtractor extractor = new QueuesResultSetExtractor();
		return extractor.extractData(resultSet);
	}

}
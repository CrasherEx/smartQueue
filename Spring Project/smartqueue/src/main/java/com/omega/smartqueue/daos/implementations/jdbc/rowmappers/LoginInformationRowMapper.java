package com.omega.smartqueue.daos.implementations.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors.LoginInformationResultSetExtractor;

public class LoginInformationRowMapper implements RowMapper
{

	public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
	{
		LoginInformationResultSetExtractor extractor = new LoginInformationResultSetExtractor();
		return extractor.extractData(resultSet);
	}

}
package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.model.LoginInformation;

public class LoginInformationResultSetExtractor implements ResultSetExtractor {

  public Object extractData(ResultSet resultSet) throws SQLException {
	LoginInformation loginInformnation = new LoginInformation(resultSet.getString("username"),resultSet.getString("password"));
	return loginInformnation;
  }

} 
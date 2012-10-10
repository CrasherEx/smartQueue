package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.enums.Gender;
import com.omega.smartqueue.model.Customer;

public class CustomerResultSetExtractor implements ResultSetExtractor
{
  public Object extractData(ResultSet resultSet) throws SQLException
  {
	  Customer customer = new Customer(resultSet.getInt("customer_id"),
										resultSet.getString("name"),
										resultSet.getString("last_name"),
										resultSet.getString("email"),
										resultSet.getString("password"),
										resultSet.getString("telephone"),
										Gender.toGender(resultSet.getString("gender")),
										resultSet.getDate("date_of_birth"),
										resultSet.getString("state"),
										resultSet.getString("city"),
										resultSet.getString("address"));
	
	  return customer;
  }
} 
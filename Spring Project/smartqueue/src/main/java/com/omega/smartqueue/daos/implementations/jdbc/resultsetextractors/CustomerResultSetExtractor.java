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
	  Gender gender;
	  if(resultSet.getString("gender").equals("M"))
	  {
		  gender = Gender.MALE;
	  }
	  else if(resultSet.getString("gender").equals("F"))
	  {
		  gender = Gender.FEMALE;  
	  }
	  else
	  {
		  gender = null;
	  }
	  Customer customer = new Customer(resultSet.getInt("customer_id"),
										resultSet.getString("name"),
										resultSet.getString("last_name"),
										resultSet.getString("email"),
										resultSet.getString("password"),
										resultSet.getString("telephone"),
										gender,
										resultSet.getDate("date_of_birth").toString(),
										resultSet.getString("state"),
										resultSet.getString("city"),
										resultSet.getString("adress"));
	
	  	return customer;
  }

} 
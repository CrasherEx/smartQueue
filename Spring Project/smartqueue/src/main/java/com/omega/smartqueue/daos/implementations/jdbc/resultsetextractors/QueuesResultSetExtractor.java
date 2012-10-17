package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.model.CustomerInQueue;

public class QueuesResultSetExtractor implements ResultSetExtractor
{
  public Object extractData(ResultSet resultSet) throws SQLException
  {
	  CustomerInQueue customerInQueue = new CustomerInQueue(resultSet.getInt("customer_in_queue_id"),
															resultSet.getInt("restaurant_id"),
															resultSet.getString("customer_name"),
															resultSet.getInt("party"),
															resultSet.getInt("position"),
															resultSet.getString("telephone"),
															resultSet.getInt("customer_id"));
	  return customerInQueue;
  }
} 
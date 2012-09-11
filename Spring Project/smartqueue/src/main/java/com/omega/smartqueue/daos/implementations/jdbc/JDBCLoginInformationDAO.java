package com.omega.smartqueue.daos.implementations.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.omega.smartqueue.daos.LoginInformationDAO;
import com.omega.smartqueue.model.LoginInformation;

public class JDBCLoginInformationDAO implements LoginInformationDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void insert(LoginInformation loginInformation)
	{
		String sqlCommandBase;
		sqlCommandBase = "INSERT INTO LOGININFO (USERNAME,PASSWORD) VALUES (?, ?)";
		
		Connection connection = null;
		
		try
		{
			connection = dataSource.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlCommandBase);
				preparedStatement.setString(1,loginInformation.getUsername());
				preparedStatement.setString(2,loginInformation.getPassword());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(SQLException sqlException)
		{
			throw new RuntimeException(sqlException);
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				}
				catch(SQLException sqlException)
				{
					
				}
			}
		}
	}

	public LoginInformation findByUsername(String username)
	{
		String sqlCommandBase;
		sqlCommandBase = "SELECT * FROM LOGININFO WHERE USERNAME = ?";
		
		Connection connection = null;
		
		try
		{
			connection = dataSource.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlCommandBase);
				preparedStatement.setString(1,username);
			LoginInformation loginInformationToReturn = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				loginInformationToReturn = new LoginInformation(
						resultSet.getString("USERNAME"),
						resultSet.getString("PASSWORD")
						);
			}
			resultSet.close();
			preparedStatement.close();
			return loginInformationToReturn;
		}
		catch(SQLException sqlException)
		{
			throw new RuntimeException(sqlException);
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				}
				catch(SQLException sqlException)
				{
					
				}
			}
		}
		
	}

}

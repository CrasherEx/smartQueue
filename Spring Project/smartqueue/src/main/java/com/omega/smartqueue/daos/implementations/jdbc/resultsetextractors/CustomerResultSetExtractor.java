package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.enums.Gender;
import com.omega.smartqueue.model.Customer;

/**
 * O ResultSetExtractor � respons�vel por extrair os registros do banco de dados,
 * transformando-os em objetos Java.
 * Neste caso, os registros do banco de dados s�o extra�dos e
 * transformados em Customers atrav�s da Class CustomerResultSetExtractor.
 */

public class CustomerResultSetExtractor implements ResultSetExtractor
{
	/**
	 * M�todo efetivamente respons�vel por extrair e transformar os registros do banco de dados
	 * em membros de dados da classe Customer
	 * 
	 * @param resultSet Um registro do banco de dados que ser� extraido e transformado em Customer
	 * @return Customer com os dados do banco de dados
	 * @throws SQLException Se algo errado ocorrer com a comunica��o no banco de dados
	 */
	
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
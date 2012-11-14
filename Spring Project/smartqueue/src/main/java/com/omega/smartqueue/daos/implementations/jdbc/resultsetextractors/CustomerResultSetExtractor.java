package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.enums.Gender;
import com.omega.smartqueue.model.Customer;

/**
 * O ResultSetExtractor é responsável por extrair os registros do banco de dados,
 * transformando-os em objetos Java.
 * Neste caso, os registros do banco de dados são extraídos e
 * transformados em Customers através da Class CustomerResultSetExtractor.
 */

public class CustomerResultSetExtractor implements ResultSetExtractor
{
	/**
	 * Método efetivamente responsável por extrair e transformar os registros do banco de dados
	 * em membros de dados da classe Customer
	 * 
	 * @param resultSet Um registro do banco de dados que será extraido e transformado em Customer
	 * @return Customer com os dados do banco de dados
	 * @throws SQLException Se algo errado ocorrer com a comunicação no banco de dados
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
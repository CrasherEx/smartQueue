/**
 * 
 */
package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.model.Restaurant;

/**
 * O ResultSetExtractor � respons�vel por extrair os registros do banco de dados,
 * transformando-os em objetos Java.
 * Neste caso, os registros do banco de dados s�o extra�dos e
 * transformados em Restaurants atrav�s da Class RestaurantResultSetExtractor.
 */

public class RestaurantResultSetExtractor implements ResultSetExtractor
{
	/**
	 * M�todo efetivamente respons�vel por extrair e transformar os registros do banco de dados
	 * em membros de dados da classe Restaurant
	 * 
	 * @param resultSet Um registro do banco de dados que ser� extraido e transformado em Restaurant
	 * @return Restaurant com os dados do banco de dados
	 * @throws SQLException Se algo errado ocorrer com a comunica��o no banco de dados
	 */
	public Object extractData(ResultSet resultSet) throws SQLException
	{
		Restaurant restaurant = new Restaurant(	resultSet.getInt("restaurant_id"),
												resultSet.getString("name"),
												resultSet.getString("email"),
												resultSet.getString("password"),
												resultSet.getString("telephone"),
												resultSet.getString("state"),
												resultSet.getString("city"),
												resultSet.getString("address")
												);

		return restaurant;
	}
}

package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.model.CustomerInQueue;

/**
 * O ResultSetExtractor é responsável por extrair os registros do banco de dados,
 * transformando-os em objetos Java.
 * Neste caso, os registros do banco de dados são extraídos e
 * transformados em CustomerInQueue através da Class QueuesResultSetExtractor.
 */

public class QueuesResultSetExtractor implements ResultSetExtractor
{
	/**
	 * Método efetivamente responsável por extrair transformar os registros do banco de dados
	 * em membros de dados da classe CustomerInQueue
	 * 
	 * @param resultSet Um registro do banco de dados que será extraido e transformado em CustomerInQueue
	 * @return CustomerInQueue com os dados do banco de dados
	 * @throws SQLException Se algo errado ocorrer com a comunicação no banco de dados
	 */
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
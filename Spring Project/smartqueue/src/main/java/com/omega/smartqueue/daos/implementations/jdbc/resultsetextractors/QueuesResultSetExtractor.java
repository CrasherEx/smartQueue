package com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.omega.smartqueue.model.CustomerInQueue;

/**
 * O ResultSetExtractor � respons�vel por extrair os registros do banco de dados,
 * transformando-os em objetos Java.
 * Neste caso, os registros do banco de dados s�o extra�dos e
 * transformados em CustomerInQueue atrav�s da Class QueuesResultSetExtractor.
 */

public class QueuesResultSetExtractor implements ResultSetExtractor
{
	/**
	 * M�todo efetivamente respons�vel por extrair transformar os registros do banco de dados
	 * em membros de dados da classe CustomerInQueue
	 * 
	 * @param resultSet Um registro do banco de dados que ser� extraido e transformado em CustomerInQueue
	 * @return CustomerInQueue com os dados do banco de dados
	 * @throws SQLException Se algo errado ocorrer com a comunica��o no banco de dados
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
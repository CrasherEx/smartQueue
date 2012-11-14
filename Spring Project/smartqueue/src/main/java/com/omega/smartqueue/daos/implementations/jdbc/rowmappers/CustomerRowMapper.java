package com.omega.smartqueue.daos.implementations.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors.CustomerResultSetExtractor;

/**
 * O RowMapper � respons�vel por mapear as linhas do banco de dados.
 * Neste caso, o CustomerRowMapper mapeia as linhas da tabela Customer
 */

public class CustomerRowMapper implements RowMapper
{
	/**
	 * M�todo respons�vel por mapear as linhas do banco de dados.
	 * 
	 * @param resultSet Registro que foi extraido do banco de dados
	 * @param rowNumber N�mero da linha do registro
	 * @throws SQLException Se a comunica��o com o banco de dados falhar
	 * @return Classe compat�vel com resultSet
	 */
	public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
	{
		CustomerResultSetExtractor extractor = new CustomerResultSetExtractor();
		return extractor.extractData(resultSet);
	}

}
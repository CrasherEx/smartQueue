/**
 * 
 */
package com.omega.smartqueue.daos.implementations.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.omega.smartqueue.daos.implementations.jdbc.resultsetextractors.RestaurantResultSetExtractor;

/**
 * O RowMapper é responsável por mapear as colunas do banco de dados.
 * Neste caso, o RestaurantRowMapper mapeia as colunas da tabela Restaurant
 */

public class RestaurantRowMapper implements RowMapper
{
	/**
	 * Método responsável por mapear as linhas do banco de dados.
	 * 
	 * @param resultSet Registro que foi extraido do banco de dados
	 * @param rowNumber Número da linha do registro
	 * @throws SQLException Se a comunicação com o banco de dados falhar
	 * @return Classe compatível com resultSet
	 */
	public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
	{
		RestaurantResultSetExtractor extractor = new RestaurantResultSetExtractor();
		return extractor.extractData(resultSet);
	}
}

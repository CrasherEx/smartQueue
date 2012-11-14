package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.Restaurant;

/**
 *	Data Acess Object para a classe Restaurant.
 *	Essa interface � utilizada pelo JDBCTemplate para unir o banco de dados � aplica��o. 
 */
public interface RestaurantDAO 
{
	/**
	 * Este m�todo � respons�vel por adicionar um novo restaurante ao banco de dados.
	 * 
	 * @param restaurant Restaurante que ser� adicionado ao banco de dados
	 */
	public void create(Restaurant restaurant);
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo email � compat�vel com o do par�metro.
	 * 
	 * @param email Email utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o email compat�vel com o do par�metro
	 */
	public List<Restaurant> selectByEmail(String email);
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo nome � compat�vel com o do par�metro.
	 * 
	 * @param name Nome utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o nome compat�vel com o do par�metro
	 */
	public List<Restaurant> selectByName(String name);
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo ID � compat�vel com o do par�metro.
	 * 
	 * @param restaurant_id ID utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o ID compat�vel com o do par�metro
	 */
	public List<Restaurant> selectById(int restaurant_id);
	/**
	 * Este m�todo utiliza a string "nameSearch" para realizar uma query no banco de dados,
	 * de modo que se um restaurante possuir em seu nome o valor da string, ainda que
	 * este n�o seja o nome do restaurante, o restaurante ser� um dos valores de
	 * retorno presente na lista.
	 * (e.g. nameSearch = "back", Outback � um valor de retorno.)
	 * 
	 * @param nameSearch String utilizada para query no banco de dados em busca
	 * de um nome de restaurante que inclua o valor da String.
	 * @return Lista de restaurantes que satisfazem a busca.
	 */
	public List<Restaurant> selectByNameSearch(String nameSearch);
	/**
	 * Este m�todo seleciona todos os restaurantes registrados no banco de dados
	 * 
	 * @return Lista de restaurantes registrados no banco de dados
	 */
	public List<Restaurant> selectAll();
}

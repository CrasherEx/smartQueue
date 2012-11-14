package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.Restaurant;

/**
 *	Data Acess Object para a classe Restaurant.
 *	Essa interface é utilizada pelo JDBCTemplate para unir o banco de dados à aplicação. 
 */
public interface RestaurantDAO 
{
	/**
	 * Este método é responsável por adicionar um novo restaurante ao banco de dados.
	 * 
	 * @param restaurant Restaurante que será adicionado ao banco de dados
	 */
	public void create(Restaurant restaurant);
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo email é compatível com o do parâmetro.
	 * 
	 * @param email Email utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o email compatível com o do parâmetro
	 */
	public List<Restaurant> selectByEmail(String email);
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo nome é compatível com o do parâmetro.
	 * 
	 * @param name Nome utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o nome compatível com o do parâmetro
	 */
	public List<Restaurant> selectByName(String name);
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os restaurantes
	 * cujo ID é compatível com o do parâmetro.
	 * 
	 * @param restaurant_id ID utilizado para a query buscando algum restaurante
	 * @return Lista de restaurantes com o ID compatível com o do parâmetro
	 */
	public List<Restaurant> selectById(int restaurant_id);
	/**
	 * Este método utiliza a string "nameSearch" para realizar uma query no banco de dados,
	 * de modo que se um restaurante possuir em seu nome o valor da string, ainda que
	 * este não seja o nome do restaurante, o restaurante será um dos valores de
	 * retorno presente na lista.
	 * (e.g. nameSearch = "back", Outback é um valor de retorno.)
	 * 
	 * @param nameSearch String utilizada para query no banco de dados em busca
	 * de um nome de restaurante que inclua o valor da String.
	 * @return Lista de restaurantes que satisfazem a busca.
	 */
	public List<Restaurant> selectByNameSearch(String nameSearch);
	/**
	 * Este método seleciona todos os restaurantes registrados no banco de dados
	 * 
	 * @return Lista de restaurantes registrados no banco de dados
	 */
	public List<Restaurant> selectAll();
}

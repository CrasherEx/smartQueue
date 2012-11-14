package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.Customer;

/**
 * Data Acess Object para a classe Customer.
 * Essa interface é utilizada pelo JDBCTemplate para unir o banco de dados à aplicação. 
 */

public interface CustomerDAO 
{
	/**
	 * Este método adicionará um novo cliente ao banco de dados.
	 * @param customer Customer que será adicionado ao banco de dados.
	 */
	public void create(Customer customer);
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os usuários
	 * que possuirem o email correspondente ao do parâmetro.
	 * 
	 * @param email Email do cliente, que será utilizado para uma query no banco de dados
	 * @return Lista de clientes com o email em questão
	 */
	public List<Customer> selectByEmail(String email);
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os usuários
	 * que possuirem o ID correspondente ao do parâmetro.
	 * @param id ID do cliente, que será utilizado para uma query no banco de dados
	 * @return Lista de clientes com o ID em questão
	 */
	public List<Customer> selectById(int id);
	/**
	 * Método que faz uma query no banco de dados e seleciona todos os clientes existentes.
	 * @return Lista de clientes registrados no banco de dados.
	 */
	public List<Customer> selectAll();
}

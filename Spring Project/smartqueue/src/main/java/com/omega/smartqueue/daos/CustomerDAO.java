package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.Customer;

/**
 * Data Acess Object para a classe Customer.
 * Essa interface � utilizada pelo JDBCTemplate para unir o banco de dados � aplica��o. 
 */

public interface CustomerDAO 
{
	/**
	 * Este m�todo adicionar� um novo cliente ao banco de dados.
	 * @param customer Customer que ser� adicionado ao banco de dados.
	 */
	public void create(Customer customer);
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os usu�rios
	 * que possuirem o email correspondente ao do par�metro.
	 * 
	 * @param email Email do cliente, que ser� utilizado para uma query no banco de dados
	 * @return Lista de clientes com o email em quest�o
	 */
	public List<Customer> selectByEmail(String email);
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os usu�rios
	 * que possuirem o ID correspondente ao do par�metro.
	 * @param id ID do cliente, que ser� utilizado para uma query no banco de dados
	 * @return Lista de clientes com o ID em quest�o
	 */
	public List<Customer> selectById(int id);
	/**
	 * M�todo que faz uma query no banco de dados e seleciona todos os clientes existentes.
	 * @return Lista de clientes registrados no banco de dados.
	 */
	public List<Customer> selectAll();
}

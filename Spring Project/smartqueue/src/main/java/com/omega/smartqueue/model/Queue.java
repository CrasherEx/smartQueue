package com.omega.smartqueue.model;

import java.util.List;

/**
 * Esta classe representa a fila na aplicação.
 * É composta, basicamente, de uma lista de clientes,
 * uma vez que apenas clientes podem entrar em filas.
 *
 */

public class Queue
{
	/**
	 * Lista de clientes na fila
	 */
	private List<Customer> queue;

	public Queue()
	{
	}

	/**
	 * Método responsável por adicionar um cliente à fila
	 * 
	 * @param customer Cliente que será adicionado à fila
	 */
	public void addCustomer(Customer customer)
	{
		queue.add(customer);
	}

	/**
	 * Método responsável por deletar um cliente da fila
	 * 
	 * @param customer Cliente que será deletado da fila
	 */
	public void deleteCustomer(Customer customer)
	{
		queue.remove(customer);
	}

	/**
	 * Retorna o número de clientes presente na fila
	 * 
	 * @return Número de clientes na fila
	 */
	public int getSize()
	{
		return queue.size();
	}

	/**
	 * Retorna a posição do cliente na fila
	 * 
	 * @param customer Cliente cuja posição na fila será verificada
	 * @return posição do cliente na fila
	 */
	public int getPosition(Customer customer)
	{
		return queue.indexOf(customer);
	}

	/**
	 * Atualiza a fila, removendo a primeira pessoa.
	 */
	public void update()
	{
		queue.remove(0);
	}
}

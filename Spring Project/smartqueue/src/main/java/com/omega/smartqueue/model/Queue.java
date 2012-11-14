package com.omega.smartqueue.model;

import java.util.List;

/**
 * Esta classe representa a fila na aplica��o.
 * � composta, basicamente, de uma lista de clientes,
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
	 * M�todo respons�vel por adicionar um cliente � fila
	 * 
	 * @param customer Cliente que ser� adicionado � fila
	 */
	public void addCustomer(Customer customer)
	{
		queue.add(customer);
	}

	/**
	 * M�todo respons�vel por deletar um cliente da fila
	 * 
	 * @param customer Cliente que ser� deletado da fila
	 */
	public void deleteCustomer(Customer customer)
	{
		queue.remove(customer);
	}

	/**
	 * Retorna o n�mero de clientes presente na fila
	 * 
	 * @return N�mero de clientes na fila
	 */
	public int getSize()
	{
		return queue.size();
	}

	/**
	 * Retorna a posi��o do cliente na fila
	 * 
	 * @param customer Cliente cuja posi��o na fila ser� verificada
	 * @return posi��o do cliente na fila
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

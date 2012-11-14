package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.CustomerInQueue;

/**
 * Data Acess Object para a classe Queue.
 * Essa interface � utilizada pelo JDBCTemplate para unir o banco de dados � aplica��o. 
 */

public interface QueuesDAO 
{
	/**
	 * Este m�todo � respons�vel por criar um novo CustomerInQueue
	 * e assimil�-lo a uma fila.
	 * @param customerInQueue Customer que ser� criado e assimilado em uma fila
	 */
	public void create(CustomerInQueue customerInQueue);
	/**
	 * M�todo que busca um restaurante atrav�s do seu ID
	 * e seleciona todos os clientes em sua fila.
	 * 
	 * @param restaurant_id ID do restaurante que ser� utilizado para a query
	 * @return Lista de clientes na fila do restaurante
	 */
	public List<CustomerInQueue> selectCustomersInQueue(int restaurant_id);
	/**
	 * Este m�todo deleta um cliente da fila.
	 * 
	 * @param customer_in_queue_id Id do cliente que deve ser deletado da fila.
	 */
	public void deleteCustomerInQueue(int customer_in_queue_id);
	
	/**
	 * Este m�todo faz uma query no banco de dados e seleciona um
	 * CustomerInQueue atrav�s do ID correspondente ao cliente registrado.
	 * @param customer_id ID do CustomerInQueue que ser� utilizado na realiza��o da query
	 * @return O CustomerInQueue correspondente ao ID passado como par�metro
	 */
	public CustomerInQueue selectByCustomerId(int customer_id);

	/**
	 * Este m�todo faz uma query no banco de dados e seleciona um
	 * CustomerInQueue atrav�s do seu ID.
	 * @param customer_id ID do CustomerInQueue que ser� utilizado na realiza��o da query
	 * @return O CustomerInQueue correspondente ao ID passado como par�metro
	 */
	public CustomerInQueue selectByCustomerInQueueId(int customer_in_queue_id);
}

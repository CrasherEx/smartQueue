package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.CustomerInQueue;

/**
 * Data Acess Object para a classe Queue.
 * Essa interface é utilizada pelo JDBCTemplate para unir o banco de dados à aplicação. 
 */

public interface QueuesDAO 
{
	/**
	 * Este método é responsável por criar um novo CustomerInQueue
	 * e assimilá-lo a uma fila.
	 * @param customerInQueue Customer que será criado e assimilado em uma fila
	 */
	public void create(CustomerInQueue customerInQueue);
	/**
	 * Método que busca um restaurante através do seu ID
	 * e seleciona todos os clientes em sua fila.
	 * 
	 * @param restaurant_id ID do restaurante que será utilizado para a query
	 * @return Lista de clientes na fila do restaurante
	 */
	public List<CustomerInQueue> selectCustomersInQueue(int restaurant_id);
	/**
	 * Este método deleta um cliente da fila.
	 * 
	 * @param customer_in_queue_id Id do cliente que deve ser deletado da fila.
	 */
	public void deleteCustomerInQueue(int customer_in_queue_id);
	
	/**
	 * Este método faz uma query no banco de dados e seleciona um
	 * CustomerInQueue através do ID correspondente ao cliente registrado.
	 * @param customer_id ID do CustomerInQueue que será utilizado na realização da query
	 * @return O CustomerInQueue correspondente ao ID passado como parâmetro
	 */
	public CustomerInQueue selectByCustomerId(int customer_id);

	/**
	 * Este método faz uma query no banco de dados e seleciona um
	 * CustomerInQueue através do seu ID.
	 * @param customer_id ID do CustomerInQueue que será utilizado na realização da query
	 * @return O CustomerInQueue correspondente ao ID passado como parâmetro
	 */
	public CustomerInQueue selectByCustomerInQueueId(int customer_in_queue_id);
}

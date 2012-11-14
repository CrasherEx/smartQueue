package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.model.Customer;

/**
 * Esta classe é responsável por validar os usuários
 */

public class CustomerValidator 
{
	/**
	 * Método que efetivamente valida os usuários passados como parâmetro
	 * 
	 * @param customers lista de usuários que deverão ser validados
	 * @return Lista de erros encontrados durante a validação
	 */
	public ArrayList<String> validate(ArrayList<Customer> customers)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		// In case the customer doesn't exist on database.
		if(customers.size() == 0)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Usuário logado com conta inexistente</b>");
		}
		
		// In case there are multiple users with the same ID on database.
		else if(customers.size() > 1)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada múltipla de usuários</b>");
		}
		
		return errorMessages;
	}
}

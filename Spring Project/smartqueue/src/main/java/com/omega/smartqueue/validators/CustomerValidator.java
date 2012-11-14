package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.model.Customer;

/**
 * Esta classe � respons�vel por validar os usu�rios
 */

public class CustomerValidator 
{
	/**
	 * M�todo que efetivamente valida os usu�rios passados como par�metro
	 * 
	 * @param customers lista de usu�rios que dever�o ser validados
	 * @return Lista de erros encontrados durante a valida��o
	 */
	public ArrayList<String> validate(ArrayList<Customer> customers)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		// In case the customer doesn't exist on database.
		if(customers.size() == 0)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Usu�rio logado com conta inexistente</b>");
		}
		
		// In case there are multiple users with the same ID on database.
		else if(customers.size() > 1)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada m�ltipla de usu�rios</b>");
		}
		
		return errorMessages;
	}
}

package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.model.Customer;

/**
	 * Verifies if the user is logged and exists on the database.
	 * 
	 * @param customerId The ID of the logged user.
	 * @param customers Array of customers with selected customerId on database.
	 * @return errorMessages Array containing all errors found.
*/
public class CustomerValidator 
{
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

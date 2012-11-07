package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.enums.UserType;


/**
	 * Validates the type of the user, in order to allow or not certain actions.
*/
public class TypeValidator
{
	
	public TypeValidator()
	{
		
	}
	/**
	 * 
	 * @param userId The ID of the logged user.
	 * @param userType The type of the logged user (Restaurant or Customer).
	 * @param idealType The specified type (in this case, you must be a customer to join a queue).
	 * @return errorMessages Array containing all errors found.
	 */
	public ArrayList<String> validate(Integer userId, UserType userType, UserType idealType)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		// In case the user is not logged on the system
		if (userId == null && userType == null)
		{
			errorMessages.add("Você precisa estar logado para entrar em uma fila. Acesse nossa <a href='login'>página de login</a> para logar-se.");
		}
		// In case the user is logged and doesn't have an ID.
		else if (userId == null || userType == null)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Chave <u>id/tipo</u> de login parcialmente nula</b>");
		}
		// In case the user is not a customer (restaurants can't join queues).
		if (userType != idealType)
		{
			errorMessages.add("É necessário ser um <b>cliente</b> para entrar na fila de um restaurante.");
		}
		
		return errorMessages;
	}
}



package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.enums.UserType;

/**
 * Esta classe é responsável por validar o usuário que entrará na fila
 */

public class TypeValidator
{
	
	/**
	 * Método que efetivamente valida o valor da string passada como parâmetro
	 * 
	 * @param userId o ID do usuário a ser validado
	 * @param userType o tipo do usuário a ser validado
	 * @param idealType o tipo que representa de qual tipo o usuário deveria ser (sempre customer, neste caso)
	 * @return Lista de erros encontrados durante a validação
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
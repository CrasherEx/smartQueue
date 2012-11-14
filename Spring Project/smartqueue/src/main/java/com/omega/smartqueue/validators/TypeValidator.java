package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.enums.UserType;

/**
 * Esta classe � respons�vel por validar o usu�rio que entrar� na fila
 */

public class TypeValidator
{
	
	/**
	 * M�todo que efetivamente valida o valor da string passada como par�metro
	 * 
	 * @param userId o ID do usu�rio a ser validado
	 * @param userType o tipo do usu�rio a ser validado
	 * @param idealType o tipo que representa de qual tipo o usu�rio deveria ser (sempre customer, neste caso)
	 * @return Lista de erros encontrados durante a valida��o
	 */
	public ArrayList<String> validate(Integer userId, UserType userType, UserType idealType)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		// In case the user is not logged on the system
		if (userId == null && userType == null)
		{
			errorMessages.add("Voc� precisa estar logado para entrar em uma fila. Acesse nossa <a href='login'>p�gina de login</a> para logar-se.");
		}
		// In case the user is logged and doesn't have an ID.
		else if (userId == null || userType == null)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Chave <u>id/tipo</u> de login parcialmente nula</b>");
		}
		// In case the user is not a customer (restaurants can't join queues).
		if (userType != idealType)
		{
			errorMessages.add("� necess�rio ser um <b>cliente</b> para entrar na fila de um restaurante.");
		}
		
		return errorMessages;
	}
}
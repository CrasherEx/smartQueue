package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * Esta classe � respons�vel por validar o valor da string "lastName"
 */

public class LastNameValidator implements SimpleValidator
{
	/**
	 * M�todo que efetivamente valida o valor da string passada como par�metro
	 * 
	 * @param stringToValidate string que ser� validada
	 * @return Lista de erros encontrados durante a valida��o
	 */
	public ArrayList<String> validate(String stringToValidate)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(stringToValidate == null)
		{
			errors.add("O campo <b>Sobrenome</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O campo <b>Sobrenome</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length()<2)
		{
			errors.add("O campo <b>Sobrenome</b> necessita possuir um nome v�lido.");
		}
		return errors;
	}

}

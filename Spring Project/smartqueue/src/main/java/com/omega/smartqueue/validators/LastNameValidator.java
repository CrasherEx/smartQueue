package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * Esta classe é responsável por validar o valor da string "lastName"
 */

public class LastNameValidator implements SimpleValidator
{
	/**
	 * Método que efetivamente valida o valor da string passada como parâmetro
	 * 
	 * @param stringToValidate string que será validada
	 * @return Lista de erros encontrados durante a validação
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
			errors.add("O campo <b>Sobrenome</b> necessita possuir um nome válido.");
		}
		return errors;
	}

}

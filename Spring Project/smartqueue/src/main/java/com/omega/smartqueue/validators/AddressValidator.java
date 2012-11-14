package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * Esta classe � respons�vel por validar o valor da string "adress"
 */

public class AddressValidator implements SimpleValidator
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
			errors.add("O campo <b>Endere�o</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O campo <b>Endere�o</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length()<3)
		{
			errors.add("O campo <b>Endere�o</b> necessita possuir ao menos <b>3 caracteres</b>.");
		}
		return errors;
	}

}

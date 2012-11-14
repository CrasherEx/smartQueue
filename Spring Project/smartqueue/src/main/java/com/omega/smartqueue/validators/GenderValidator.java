package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * Esta classe � respons�vel por validar o valor da string "gender"
 */

public class GenderValidator implements SimpleValidator
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
			errors.add("O campo <b>Sexo</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals("none"))
		{
			errors.add("O campo <b>Sexo</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals("male") == false && stringToValidate.equals("female") == false)
		{
			errors.add("O campo <b>Sexo</b> possui valores inv�lidos para sexo.");
		}
		return errors;
	}

}

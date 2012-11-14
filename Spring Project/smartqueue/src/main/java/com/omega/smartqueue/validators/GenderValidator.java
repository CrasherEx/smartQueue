package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * Esta classe é responsável por validar o valor da string "gender"
 */

public class GenderValidator implements SimpleValidator
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
			errors.add("O campo <b>Sexo</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals("none"))
		{
			errors.add("O campo <b>Sexo</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals("male") == false && stringToValidate.equals("female") == false)
		{
			errors.add("O campo <b>Sexo</b> possui valores inválidos para sexo.");
		}
		return errors;
	}

}

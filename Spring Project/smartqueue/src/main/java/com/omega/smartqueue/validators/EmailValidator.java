package com.omega.smartqueue.validators;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta classe � respons�vel por validar o valor da string "email"
 */

public class EmailValidator implements SimpleValidator
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
			errors.add("O campo <b>E-Mail</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O campo <b>E-Mail</b> necessita ser preenchido.");
		}
		else
		{
			Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
			Matcher matcher = pattern.matcher(stringToValidate);
			if(matcher.find() == false) 
			{
				errors.add("Um e-mail inv�lido foi inserido no campo <b>E-Mail</b>.");
			}
		}
		return errors;
	}

}

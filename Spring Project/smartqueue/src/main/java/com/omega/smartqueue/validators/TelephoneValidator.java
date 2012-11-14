package com.omega.smartqueue.validators;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta classe � respons�vel por validar o valor da string "telephone"
 */

public class TelephoneValidator implements SimpleValidator
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
			errors.add("A parte principal do campo <b>Telefone</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("A parte principal do campo <b>Telefone</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length() < 6 || stringToValidate.length() > 14)
		{
			errors.add("A parte principal do campo <b>Telefone</b> necessita ter entre <b>6</b> e <b>14</b> algarismos.");
		}
		else
		{
			Pattern pattern = Pattern.compile("^[0-9]{6,14}$");
			Matcher matcher = pattern.matcher(stringToValidate);
			if(matcher.find() == false) 
			{
				errors.add("A parte principal do campo <b>Telefone</b> deve ser composta somente de <b>n�meros</b>.");
			}
		}
		return errors;
	}

}

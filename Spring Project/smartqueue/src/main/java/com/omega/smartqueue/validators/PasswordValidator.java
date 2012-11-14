package com.omega.smartqueue.validators;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta classe é responsável por validar o valor da string "password"
 */

public class PasswordValidator implements SimpleValidator
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
			errors.add("O campo <b>Senha</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O campo <b>Senha</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length()<6 || stringToValidate.length()>16)
		{
			errors.add("O campo <b>Senha</b> necessita ter entre <b>6</b> e <b>16</b> caracteres.");
		}
		else
		{
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9_#$%&]{6,16}$");
			Matcher matcher = pattern.matcher(stringToValidate);
			if(matcher.find() == false) 
			{
				errors.add("O campo <b>Senha</b> pode conter somente <b>letras</b>, <b>números</b>, e os caracteres <b>_#$%&</b>.");
			}
		}
		return errors;
	}

}

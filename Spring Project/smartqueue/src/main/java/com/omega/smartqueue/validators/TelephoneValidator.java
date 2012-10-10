package com.omega.smartqueue.validators;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneValidator implements SimpleValidator
{

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
		else if(stringToValidate.length() < 7 || stringToValidate.length() > 10)
		{
			errors.add("A parte principal do campo <b>Telefone</b> necessita ter entre <b>7</b> e <b>10</b> algarismos.");
		}
		else
		{
			Pattern pattern = Pattern.compile("^[0-9]{7,10}$");
			Matcher matcher = pattern.matcher(stringToValidate);
			if(matcher.find() == false) 
			{
				errors.add("A parte principal do campo <b>Telefone</b> deve ser composta somente de <b>números</b>.");
			}
		}
		return errors;
	}

}

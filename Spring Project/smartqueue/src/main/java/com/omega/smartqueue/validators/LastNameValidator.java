package com.omega.smartqueue.validators;

import java.util.ArrayList;

public class LastNameValidator implements SimpleValidator
{
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

package com.omega.smartqueue.validators;

import java.util.ArrayList;

public class NameValidator implements SimpleValidator
{
	public ArrayList<String> validate(String stringToValidate)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(stringToValidate == null)
		{
			errors.add("O campo <b>Nome</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O campo <b>Nome</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length()<2)
		{
			errors.add("O campo <b>Nome</b> necessita possuir um nome válido.");
		}
		return errors;
	}

}

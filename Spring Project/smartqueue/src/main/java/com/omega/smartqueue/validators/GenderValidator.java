package com.omega.smartqueue.validators;

import java.util.ArrayList;

public class GenderValidator implements SimpleValidator
{
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

package com.omega.smartqueue.validators;

import java.util.ArrayList;

public class AddressValidator implements SimpleValidator
{

	public ArrayList<String> validate(String stringToValidate)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(stringToValidate == null)
		{
			errors.add("O campo <b>Endereço</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O campo <b>Endereço</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length()<3)
		{
			errors.add("O campo <b>Endereço</b> necessita possuir ao menos <b>3 caracteres</b>.");
		}
		return errors;
	}

}

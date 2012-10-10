package com.omega.smartqueue.validators;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephonePrefixValidator implements SimpleValidator
{

	public ArrayList<String> validate(String stringToValidate)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(stringToValidate == null)
		{
			errors.add("O <b>prefixo</b> do campo <b>Telefone</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals(""))
		{
			errors.add("O <b>prefixo</b> do campo <b>Telefone</b> necessita ser preenchido.");
		}
		else if(stringToValidate.length() != 2)
		{
			errors.add("O <b>prefixo</b> do campo <b>Telefone</b> necessita ter exatamente <b>2</b> caracteres.");
		}
		else
		{
			Pattern pattern = Pattern.compile("^[0-9]{2}$");
			Matcher matcher = pattern.matcher(stringToValidate);
			if(matcher.find() == false) 
			{
				errors.add("O <b>prefixo</b> do campo <b>Telefone</b> ser composto somente de <b>números</b>");
			}
		}
		return errors;
	}

}

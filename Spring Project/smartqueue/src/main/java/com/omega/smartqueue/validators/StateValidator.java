package com.omega.smartqueue.validators;

import java.util.ArrayList;

public class StateValidator implements SimpleValidator
{

	public ArrayList<String> validate(String stringToValidate)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(stringToValidate == null)
		{
			errors.add("O campo <b>Estado</b> necessita ser preenchido.");
		}
		else if(stringToValidate.equals("none"))
		{
			errors.add("O campo <b>Estado</b> necessita ser preenchido.");
		}
		else
		{
			String[][] states = {
					{"Acre","AC"},
					{"Alagoas","AL"},
					{"Amapá","AP"},
					{"Amazonas","AM"},
					{"Bahia","BA"},
					{"Ceará","CE"},
					{"Distrito Federal","DF"},
					{"Espírito Santo","ES"},
					{"Goiás","GO"},
					{"Maranhão","MA"},
					{"Mato Grosso","MT"},
					{"Mato Grosso do Sul","MS"},
					{"Minas Gerais","MG"},
					{"Pará","PA"},
					{"Paraíba","PB"},
					{"Paraná","PR"},
					{"Pernambuco","PE"},
					{"Piauí","PI"},
					{"Rio de Janeiro","RJ"},
					{"Rio Grande do Norte","RN"},
					{"Rio Grande do Sul","RS"},
					{"Rondônia","RO"},
					{"Roraima","RR"},
					{"Santa Catarina","SC"},
					{"São Paulo","SP"},
					{"Sergipe","SE"},
					{"Tocantins","TO"}
					};
			boolean isValid = false;
			for(int stateIndex=1;stateIndex<=27;stateIndex++)
			{
				if(stringToValidate.equals(states[stateIndex-1][1]))
				{
					isValid = true;
					break;
				}
			}
			if(!isValid)
			{
				errors.add("O campo <b>Estado</b> necessita ser preenchido com um estado válido.");
			}
		}
		return errors;
	}

}

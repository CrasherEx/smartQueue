package com.omega.smartqueue.validators;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DateValidator
{
	public ArrayList<String> validate(String dayToValidade,String monthToValidate,String yearToValidate)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(dayToValidade == null || monthToValidate == null || yearToValidate == null)
		{
			errors.add("O campo <b>Data de Nascimento</b> necessita ser preenchido.");
		}
		else if(dayToValidade.equals("") || monthToValidate.equals("")  || yearToValidate.equals("") )
		{
			errors.add("O campo <b>Data de Nascimento</b> necessita ser preenchido.");
		}
		else if(dayToValidade.equals("none")  || monthToValidate.equals("none")|| yearToValidate.equals("none") )
		{
			errors.add("O campo <b>Data de Nascimento</b> necessita ser preenchido.");
		}
		else
		{
			try
			{
				Integer integerDayToValidate = Integer.parseInt(dayToValidade);
				Integer integerMonthToValidate = Integer.parseInt(monthToValidate);
				Integer integerYearToValidate = Integer.parseInt(yearToValidate);
				
				if(integerYearToValidate < 1900 || integerYearToValidate > 2012)
				{
					errors.add("O <b>Ano</b> da <b>Data de Nascimento</b> necessita estar entre <b>1900</b> e <b>2012</b>");
				}
				
				if(integerMonthToValidate < 1 || integerMonthToValidate > 12)
				{
					errors.add("O <b>Mês</b> inserido na <b>Data de Nascimento</b> não existe.");
				}
				
				int valueToCheckDivision = integerMonthToValidate;
				if(integerMonthToValidate >= 8)
				{
					valueToCheckDivision--;
				}
				if(valueToCheckDivision % 2 == 0)
				{
					// Meses que possuem 30 dias
					// Exceção: Fevereiro (mês 2)
					if(integerMonthToValidate == 2)
					{
						// Mês de fevereiro
						// Possui 29 ou 28 dias, dependendo se o ano é bissexto
						GregorianCalendar gregorianCalendar = new GregorianCalendar();
						if(gregorianCalendar.isLeapYear(integerYearToValidate))
						{
							// Anos bissextos
							if(integerDayToValidate < 1 || integerDayToValidate > 29)
							{
								errors.add("O <b>Dia</b> inserido na <b>Data de Nascimento</b> não existe.");
							}
						}
						else
						{
							// Anos normais
							if(integerDayToValidate < 1 || integerDayToValidate > 28)
							{
								errors.add("O <b>Dia</b> inserido na <b>Data de Nascimento</b> não existe.");
							}
						}
					}
					else
					{
						// Meses que possuem 30 dias, que não são Fevereiro
						if(integerDayToValidate < 1 || integerDayToValidate > 30)
						{
							errors.add("O <b>Dia</b> inserido na <b>Data de Nascimento</b> não existe.");
						}
					}
				}
				else
				{
					// Meses com 31 dias
					if(integerDayToValidate < 1 || integerDayToValidate > 31)
					{
						errors.add("O <b>Dia</b> inserido na <b>Data de Nascimento</b> não existe.");
					}
				}
			}
			catch(NumberFormatException numberFormatException)
			{
				errors.add("O campo <b>Data de Nascimento</b> possui valores inválidos para datas.");
			}
		}
		return errors;
	}

}

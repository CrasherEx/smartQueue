package com.omega.smartqueue.enums;

/**
 * Enumera��o para g�nero masculino e feminino.
 *
 */
public enum Gender
{
	MALE("M"),
	FEMALE("F");
	
	private String innerString;
	
	Gender(String string)
	{
		innerString = string;
	}
	
	@Override
	public String toString()
	{
		return innerString;
	}
	
	/**
	 * Converte uma string recebida por par�metro para uma constante
	 * de enumera��o correspondente.
	 * 
	 * @param string String que ser� convertida em constante de enumera��o
	 * @return Constante de enumera��o, caso seja poss�vel converter
	 * @return null, caso n�o seja poss�vel converter
	 */
	
	public static Gender toGender(String string)
	{
		if(string.equals("male")) return Gender.MALE;
		else if(string.equals("M")) return Gender.MALE;
		else if(string.equals("female")) return Gender.FEMALE;
		else if(string.equals("F")) return Gender.FEMALE;
		else return null;
	}
}

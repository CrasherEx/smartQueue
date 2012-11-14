package com.omega.smartqueue.enums;

/**
 * Enumeração para gênero masculino e feminino.
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
	 * Converte uma string recebida por parâmetro para uma constante
	 * de enumeração correspondente.
	 * 
	 * @param string String que será convertida em constante de enumeração
	 * @return Constante de enumeração, caso seja possível converter
	 * @return null, caso não seja possível converter
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

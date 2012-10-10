package com.omega.smartqueue.enums;

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
	
	public static Gender toGender(String string)
	{
		if(string.equals("male")) return Gender.MALE;
		else if(string.equals("M")) return Gender.MALE;
		else if(string.equals("female")) return Gender.FEMALE;
		else if(string.equals("F")) return Gender.FEMALE;
		else return null;
	}
}

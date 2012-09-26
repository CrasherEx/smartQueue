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
}

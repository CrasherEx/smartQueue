package com.omega.smartqueue.database;

/**
 * @author Jean Ghissoni
 * This enumeration contains a enumeration constants for the values that can be saved in a table.
 * Each value stands for a different table.
 */

//Falar sobre a estrutura de dados e blabla

public enum DataStructure
{
	USER(1),
	QUEUE(1),
	RESTAURANT_PROFILE(1),
	CUSTOMER_PROFILE(1);
	
	
	/**
	 * This variable corresponds to the number of savable attributes each enumeration constant contains.
	 */
	private int numberOfData;
	
	/**
	 * @param _numberOfData number of DataStructure's attributes that will be saved.
	 */
	DataStructure(int _numberOfData)
	{
		numberOfData = _numberOfData;
	}
	
	/**
	 * Method that returns the value of numberOfData
	 * @return Returns the number of data the enumeration constants has.
	 */
	public int getNumberOfData()
	{
		return numberOfData;
	}
}

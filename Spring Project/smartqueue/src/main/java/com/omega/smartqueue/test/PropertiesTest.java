package com.omega.smartqueue.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */

/**
 * @author LAB116
 *
 */
public class PropertiesTest {

	/**
	 * Testing Properties
	 * @param args
	 */
	public static void main(String[] args) 
		
	{
			Properties restProp = new Properties();
			restProp.setProperty ("Luccas", "LuccasPassword");
			restProp.setProperty ("Mr.Shrebles", "ShreblesPassword");
			
			//prop.getProperty("keyname"); returns the value
			//example: prop.getProperty("username1"); returns "password1"
			
			try 
			{
				restProp.store(new FileOutputStream("configTest.properties", true) , "Restaurant's Users");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Properties bankProp = new Properties();
			bankProp.setProperty ("PoliceGuy", "PGPassword");
			bankProp.setProperty ("BankOwner", "OwnerPassword");
			
			try
			{
				bankProp.store(new FileOutputStream("configTest.properties", true), "Bank's Users");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			restProp.setProperty ("LateUser", "LatePassword");
			try 
			{
				restProp.store(new FileOutputStream("configTest.properties", true) , "Restaurant's Users");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
			
			

	}
}

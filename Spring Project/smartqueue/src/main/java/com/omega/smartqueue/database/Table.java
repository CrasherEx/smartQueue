package com.omega.smartqueue.database;

import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Luccas Laquintinie Amaral
 *
 */
class Table
{
	private String filePath;
	
	/**Sets object's file path.
	 * 
	 * @param newFilePath
	 */
	
	public Table(String filePath)
	{
		this.filePath = filePath;
	}
	
	public void setFilePath ( String filePath )
	{
		this.filePath = filePath;
	}
	
	/**
	 * Saves an object.
	 * 
	 * @param objectToSave
	 * @throws IOException
	 * @see Savable
	 * @see DataStructure
	 */
	public void save ( Savable objectToSave)
	{
		ArrayList<String> objectInfo = new ArrayList<String>();
		objectInfo = objectToSave.getAttributesAsString();
		
		try 
		{
			FileWriter writer = new FileWriter(filePath);
			BufferedWriter out = new BufferedWriter(writer);
			for (String info : objectInfo)
			{
				out.write(info);
			}
			out.close();
		} 
		catch (IOException exception) 
		{
			System.err.println ("Error" + exception.getMessage());
			exception.printStackTrace();
		}
		
		
	}
	
	/**
	 * Reads object's information from file path.
	 * 
	 * @return
	 */
	public ArrayList<Savable> read ()
	{
		return null;
	}
	
	/**
	 * Deletes an object.
	 * 
	 * @param objectToDelete
	 */
	public void delete ( Savable objectToDelete)
	{
		
	}
	
	/**
	 * Update object's information.
	 * 
	 * @param oldObject
	 * @param newObject
	 */
	public void update ( Savable oldObject, Savable newObject)
	{
		
	}
	
	/**
	 * Checks if an object exists on database.
	 * 
	 * @param objectToCheck
	 * @return true or @return false
	 */
	public boolean exists ( Savable objectToCheck)
	{
		
		return true;
	}
	
}

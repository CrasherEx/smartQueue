/**
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details
 */

package com.omega.smartqueue.database;

import java.util.ArrayList;
import java.util.HashMap;

import com.omega.smartqueue.exceptions.IncompatibleAmountOfAttributesReturnedException;

/**
 * This class consists of a database.
 * It follows the Singleton design pattern.
 * It creates, reads, updates and deletes data from database tables (CRUD operations).
 * 
 * In order for a instance of the class "A" to be saved in the database,
 * "A" has to implement {@link Savable}. Each {@link Savable} defines a {@link DataStructure}.
 * Different {@link DataStructure}s will be saved on different {@link Table}s.
 * 
 * All the {@link Table}s are located in the same path, defined by {@code ROOT_PATH}.
 * 
 * @author Ian Albuquerque Raymundo da Silva
 * @see Table
 * @see Savable
 * @see DataStructure
 * @see HashMap
 * @see String
 * @see ArrayList
 *
 */

public class Database
{

	/**
	 * The instance of the Database. Only one instance exists, since Database follows the Singleton design pattern.
	 */
	static private Database database;
	
	/**
	 * The path to the folder where the {@link Table}s will be stored.
	 */
	static private String ROOT_PATH = "";
	
	/**
	 * The Mapping between every {@link DataStructure} and it's correspondent {@link Table}
	 */
	private HashMap<DataStructure,Table> tables;
	
	/**
	 * The constructor.
	 * Builds {@code tables}, associating for each {@link DataStructure} a correspondent {@link Table}.
	 */
	protected Database()
	{
		/*
		 * Creates a Map entry for each DataStructure available.
		 */
		for(DataStructure dataStructureToMap:DataStructure.values())
		{
			tables.put(dataStructureToMap, new Table(ROOT_PATH + "//" + dataStructureToMap.toString()));
		}
	}
	
	/**
	 * Method that enables the access to the unique instance of Database
	 * @return the unique instance of Database, as defined in the Singleton design pattern. 
	 */
	public static Database getDatabase()
	{
		if(database == null)
		{
			database = new Database();
		}
		return database;
	}
	
	/**
	 * Saves a {@link Savable} object in the database, in it's correspondent table.
	 * 
	 * @throws IncompatibleAmountOfAttributesReturnedException if the amount of data being provided
	 * by the {@link Savable} object being saved doesn't match the {@link DataStructure} followed. 
	 * 
	 * @param objectToSave the {@link Savable} object to be saved in the database.
	 */
	public void save(Savable objectToSave) throws IncompatibleAmountOfAttributesReturnedException
	{
		/*
		 * Checks if the number of attributes being provided by the objectToSave corresponds to it DataStructure
		 */
		if(objectToSave.getAttributesAsString().size() != objectToSave.getDataStructure().getNumberOfData())
		{
			throw new IncompatibleAmountOfAttributesReturnedException();
		}
		
		/*
		 * Asks the correspondent table to save the object.
		 */
		tables.get(objectToSave.getDataStructure()).save(objectToSave);
	}
	
	
}
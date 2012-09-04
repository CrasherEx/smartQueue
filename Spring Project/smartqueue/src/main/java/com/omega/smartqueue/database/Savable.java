package com.omega.smartqueue.database;

import java.util.ArrayList;

/**
 * 
 * @author Jean Ghissoni
 * This interface is used to define the behavior of a class.
 * The class that implements this interface must have a list of savable attributes and a type of DataStructure. 
 */

public interface Savable 
{
	/**
	 * @return This method returns a list of String in which each String corresponds to a savable attribute of a Class(e.g User contains e-mail, name, etc).
	 */
	public ArrayList<String> getAttributesAsString();
	
	/**
	 * @return This method returns the type of DataStructure of a class. Each Class has a different type of DataStructure (e.g User's DataStrucutre is USER)
	 */
	public DataStructure getDataStructure();
}

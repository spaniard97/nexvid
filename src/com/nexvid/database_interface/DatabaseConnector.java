package com.nexvid.database_interface;

/**
 * The DatabaseConnector class gets connections with the
 * database to perform queries.  The sendQuery() method informs
 * if the query was successful or if it failed.
 * @author Juan Carlos Pinillos
 */
public class DatabaseConnector {
	
	/**
	 * Gets a connection with the database
	 * @return true if the connection is successful, false if it failed.
	 */
	public boolean getConnection(){
		return true;
	}
	
	/**
	 * Sends a query to the database 
	 * @return true if the query is successful, false if it failed
	 */
	public boolean sendQuery(){
		return true;
	}
}

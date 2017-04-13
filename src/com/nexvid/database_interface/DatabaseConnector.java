package com.nexvid.database_interface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 * The DatabaseConnector class gets connections with the
 * database to perform queries.  The sendQuery() method informs
 * if the query was successful or if it failed.
 * @author Juan Carlos Pinillos
 */
public class DatabaseConnector {
	private String user = "";
	private String password = "";
	private String dbUrl = "";
	
	public DatabaseConnector() throws FileNotFoundException, IOException{
		Properties props = new Properties();
		props.load(new FileInputStream("src/db.properties"));
		
		this.user = props.getProperty("user");
		this.password = props.getProperty("password");
		this.dbUrl = props.getProperty("dburl");
	}
	
	/**
	 * Gets the database user
	 * @return the database user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Sets the user
	 * @param user the database user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Gets the database password for the user
	 * @return the database user password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the database url
	 * @return the database url
	 */
	public String getDbUrl() {
		return dbUrl;
	}

	/**
	 * Sets the database url
	 * @param dbUrl the database url
	 */
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	/**
	 * Gets a connection with the database
	 * @return A connection object of the database.
	 * @throws SQLException if there is an error
	 */
	public Connection getConnection() throws SQLException{
		//Create a null connection object
		
		Connection myConn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			myConn = DriverManager.getConnection(this.getDbUrl(), this.getUser(), this.getPassword());
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
		
		return myConn;
	}
	
	/**
	 * Ends a connection to the database
	 * @return true if the connection was successfully closed.
	 * @throws SQLException if there is an error
	 */
	public boolean endConnection(Connection myConn) throws SQLException{
		try{
			if (myConn != null) {
				myConn.close();
			}			
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
		return true;
	}
	
	//I am not sure if the sendQuery() method is needed or will be used.
	
	/**
	 * Sends a query to the database 
	 * @return true if the query is successful, false if it failed
	 */
	public boolean sendQuery(){
		return true;
	}
}

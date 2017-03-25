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
	
	/*public static void main(String args[]) throws SQLException{
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://nexvid.perazil.com:3306/NexVid2?useSSL=false", "java" , "nexvid2301");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("SELECT * FROM Account WHERE `city` = 'Vancouver'");
			
			System.out.println(myRs.findColumn("account_ID"));

			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("account_ID") + ", " + myRs.getString("first_name") + ", " + myRs.getString("last_name") +
						", " + myRs.getString("city"));
				
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}

		
	}*/
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbUrl() {
		return dbUrl;
	}

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
	
	/**
	 * Sends a query to the database 
	 * @return true if the query is successful, false if it failed
	 */
	public boolean sendQuery(){
		return true;
	}
}

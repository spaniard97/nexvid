package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;
import com.nexvid.accounts.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


/**
 * This class reads data from the database using SELECT queries
 * @author Russell Hanson
 * @author Juan Carlos Pinillos
 */
public class DBReader 
{
	/**
	 * Retrieves an account from the database
	 * @param account_ID the account's ID number
	 * @return the Account object or NULL
	 * @throws SQLException if an error occurs
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static Account getAccountQuery(int account_ID) throws SQLException, FileNotFoundException, IOException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			//PreparedStatement myStmt = myConn.prepareStatement("SELECT * from Account WHERE `account_ID` = ?");
			myStmt = myConn.prepareCall("{call get_account_info(?)}");
			
			//Sets the parameter for the prepared statement.  
			myStmt.setInt(1, account_ID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Temporary until we get the classes all completed and can create objects to pass the info
			while (myRs.next()) {
				
				//Account myAccount = new Account();
				
				System.out.println(myRs.getString("account_ID") + ", " + myRs.getString("first_name") + ", " + myRs.getString("last_name") +
						", " + myRs.getString("city"));
				
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			System.out.println(db.endConnection(myConn)); //Closes the connection to the database
		}
		
		return null;
	}
	
	/**
	 * Retrieves a sub-account from the database
	 * @param sub_ID the sub-account's ID number
	 * @return the SubAccount object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static SubAccount getSubAccountQuery(int sub_ID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_subAccount_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, sub_ID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Temporary until we get the classes all completed and can create objects to pass the info
			while(myRs.next()){
				System.out.println(myRs.getString("sub_ID") + ", " + myRs.getString("d_o_b") + ", " + myRs.getString("first_name") + 
						", " + myRs.getString("last_name") + ", " + myRs.getString("active") + ", " + myRs.getString("account_ID"));
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			System.out.println(db.endConnection(myConn)); //Closes the connection
		}
		return null;
	}
	
	/**
	 * Retrieves a media from the database
	 * @param online_ID the media's online ID number
	 * @return the Media object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static Media getMediaQuery(int online_ID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_media_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, online_ID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Temporary until we get the classes all completed and can create objects to pass the info
			while(myRs.next()){
				System.out.println(myRs.getString("media_ID") + ", " + myRs.getString("title") + ", " + myRs.getString("times_rented") + 
						", " + myRs.getString("online_ID") + ", " + myRs.getString("type") + ", " + myRs.getString("price_ID") + ", " + 
						myRs.getString("format_ID"));
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			System.out.println(db.endConnection(myConn)); //Closes the connection
		}
		return null;
	}
	
	/**
	 * Retrieves all the copies associated with a media
	 * @param media_ID the media's ID number
	 * @return a list of media copies
	 * @throws SQLException if there is an error
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static MediaCopy[] getMediaCopiesQuery(int media_ID) throws SQLException, FileNotFoundException, IOException
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaCopies_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, media_ID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Temporary until we get the classes all completed and can create objects to pass the info
			while(myRs.next()){
				System.out.println(myRs.getString("copy_ID") + ", " + myRs.getString("rental_status") + ", " + myRs.getString("reservation_status") + 
						", " + myRs.getString("state") + ", " + myRs.getString("active") + ", " + myRs.getString("media_ID"));
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			System.out.println(db.endConnection(myConn)); //Closes the connection
		}
		return null;
	}
	
	/**
	 * Retrieves a media copy from the database
	 * @param copy_ID the media copy's ID number
	 * @return the MediaCopy object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static MediaCopy getMediaCopyQuery(int copy_ID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaCopy_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, copy_ID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Temporary until we get the classes all completed and can create objects to pass the info
			while(myRs.next()){
				System.out.println(myRs.getString("copy_ID") + ", " + myRs.getString("rental_status") + ", " + myRs.getString("reservation_status") + 
						", " + myRs.getString("state") + ", " + myRs.getString("active") + ", " + myRs.getString("media_ID"));
				DBReader.getMediaQuery(myRs.getInt("media_ID"));
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			System.out.println(db.endConnection(myConn)); //Closes the connection
		}
		return null;
	}
	
	/**
	 * Retrieves a tv show disk from the database
	 * @param media_ID the tv show disk's ID number
	 * @return the TVShowDisk object or NULL
	 */
	public TvShowDisk getTVShowDiskQuery(int media_ID) 
	{
		return null;
	}
	
	/**
	 * Retrieves a rental from the database
	 * @param rental_ID the rental's ID number
	 * @return the Rental object or NULL
	 */
	public Rental getRentalQuery(int rental_ID) 
	{
		return null;
	}
	
	/**
	 * Retrieves a reservation from the database
	 * @param reservation_ID the reservation's ID number
	 * @return the Reservation object or NULL
	 */
	public Reservation getReservationQuery(int reservation_ID) 
	{
		return null;
	}
	
	/**
	 * Checks if the given email and password match an account
	 * @param email an email address 
	 * @param password a password
	 * @return True if a match is found, False if no match is found
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static Account loginQuery(String email, String password) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call login(?, ?)}");
			
			//Sets the parameter for the prepared statement.  
			myStmt.setString(1, email);
			myStmt.setString(2, password);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
						
			//Temporary until we get the classes all completed and can create objects to pass the info
			while (myRs.next()) {
				
				//Account myAccount = new Account();
				
				System.out.println(myRs.getString("account_ID") + ", " + myRs.getString("email") + ", " + myRs.getString("password"));
				
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			System.out.println(db.endConnection(myConn)); //Closes the connection to the database
		}

		return null;
	}
	
	/**
	 * Retrieves the ID of the last record added to the database.
	 * This is used to get IDs when a record is added since the database auto increments the IDs.
	 * @return The ID of the last record added.
	 */
	public int getLastIdAddedQuery()
	{
		return 0;
	}
}
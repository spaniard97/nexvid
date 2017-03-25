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
		//Creates a Database object to establish a connection
		DatabaseConnector db = new DatabaseConnector();
		Connection myConn = db.getConnection();
		
		// Creates a prepared statement query
		//PreparedStatement myStmt = myConn.prepareStatement("SELECT * from Account WHERE `account_ID` = ?");
		CallableStatement myStmt = myConn.prepareCall("{call get_account_info(?)}");
		myStmt.setInt(1, account_ID); //uses the prepared statement
		
		//Execute the query to the database
		ResultSet myRs = myStmt.executeQuery();
		
		while (myRs.next()) {
			
			//Account myAccount = ();
			
			System.out.println(myRs.getString("account_ID") + ", " + myRs.getString("first_name") + ", " + myRs.getString("last_name") +
					", " + myRs.getString("city"));
			
		}
		System.out.println(db.endConnection(myConn)); //Closes the connection to the database
		
		return null;
	}
	
	/**
	 * Retrieves a sub-account from the database
	 * @param sub_ID the sub-account's ID number
	 * @return the SubAccount object or NULL
	 */
	public SubAccount getSubAccountQuery(int sub_ID) 
	{
		return null;
	}
	
	/**
	 * Retrieves a media from the database
	 * @param online_ID the media's online ID number
	 * @return the Media object or NULL
	 */
	public Media getMediaQuery(int online_ID) 
	{
		return null;
	}
	
	/**
	 * Retrieves all the copies associated with a media
	 * @param media_ID the media's ID number
	 * @return a list of media copies
	 * @throws SQLException if there is an error
	 */
	public MediaCopy[] getMediaCopiesQuery(int media_ID) throws SQLException
	{
		DatabaseConnector db = null;
		
		Statement myStmt = db.getConnection().createStatement();
		
		ResultSet myRs = myStmt.executeQuery("SELECT * FROM MediaCopy WHERE `media_ID` = media_ID");
		
		
		
		while (myRs.next()) {
			
			
			System.out.println(myRs.getString("account_ID") + ", " + myRs.getString("first_name") + ", " + myRs.getString("last_name") +
					", " + myRs.getString("city"));
			
		}
		
		return null;
	}
	
	/**
	 * Retrieves a media copy from the database
	 * @param copy_ID the media copy's ID number
	 * @return the MediaCopy object or NULL
	 */
	public MediaCopy getMediaCopy(int copy_ID) 
	{
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
	 */
	public boolean loginQuery(String email, String password) 
	{
		return true;
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
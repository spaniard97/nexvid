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
	public static Account getAccountQuery(int accountID) throws SQLException, FileNotFoundException, IOException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Account account = new Account(0, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0.00, null, null);
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			//PreparedStatement myStmt = myConn.prepareStatement("SELECT * from Account WHERE `account_ID` = ?");
			myStmt = myConn.prepareCall("{call get_account_info(?)}");
			
			//Sets the parameter for the prepared statement.  
			myStmt.setInt(1, accountID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while (myRs.next()) {
				
				account.setAccountID(myRs.getInt("account_ID"));
				account.setFirstName(myRs.getString("first_name"));
				account.setLastName(myRs.getString("last_name"));
				account.setPhoneNumber(myRs.getString("phone"));
				account.setEmail(myRs.getString("email"));
				account.setProvince(myRs.getString("province"));
				account.setCity(myRs.getString("city"));
				account.setPostalCode(myRs.getString("postal_code"));
				account.setCountry(myRs.getString("country"));
				account.setStreetName(myRs.getString("street_name"));
				account.setApartmentNumber(myRs.getInt("apt_number"));
				account.setStreetNumber(myRs.getInt("street_number"));
				account.setAccountType(myRs.getString("type"));
				account.setStatus(myRs.getString("status"));
				account.setBalanceOwed(myRs.getDouble("balance"));
				account.setPassword(myRs.getString("password"));
				account.setPassPhrase(myRs.getString("passphrase"));
								
				System.out.println(account.getAccountID() + ", " + account.getFirstName() + ", " + account.getLastName() +
						", " + account.getPhoneNumber() + ", " + account.getEmail());
				
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
		
		return account;
	}
	
	/**
	 * Retrieves a sub-account from the database
	 * @param sub_ID the sub-account's ID number
	 * @return the SubAccount object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static SubAccount getSubAccountQuery(int subID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		SubAccount subAccount = new SubAccount(0, null, null, null, false, 0);
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_subAccount_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, subID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				subAccount.setSubAccountID(subID);
				subAccount.setDateOfBirth(myRs.getDate("d_o_b"));
				subAccount.setFirstName(myRs.getString("first_name"));
				subAccount.setLastName(myRs.getString("last_name"));
				subAccount.setActive(myRs.getBoolean("active"));
				subAccount.setAccountID(myRs.getInt("account_ID"));				
				
				System.out.println(subAccount.getSubAccountID() + ", " + subAccount.getDateOfBirth() + ", " + subAccount.getFirstName() + ", " + subAccount.getLastName() + 
						", " + subAccount.isActive() + ", " + subAccount.getAccountID());
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
		return subAccount;
	}
	
	/**
	 * Retrieves a media from the database
	 * @param online_ID the media's online ID number
	 * @return the Media object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static Media getMediaQuery(int onlineID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Media media = new Media(0, null, 0, 0, null, null, null);
		PriceTier price = new PriceTier(0, 0, null, 0.00);
		Format format = new Format();
		
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_media_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, onlineID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				media.setMediaId(myRs.getInt("media_ID"));
				media.setTitle(myRs.getString("title"));
				media.setTimesRented(myRs.getInt("times_rented"));
				media.setOnlineID(myRs.getInt("online_ID"));
				media.setType(myRs.getString("type"));
				price.setPriceID(myRs.getInt("price_ID"));
				media.setPrice(price);
				format.setFormatID(myRs.getInt("format_ID"));
				media.setFormat(format);
				
				
				
				System.out.println(media.getMediaId() + ", " + media.getTitle() + ", " + media.getTimesRented() + 
						", " + media.getOnlineID() + ", " + media.getType() + ", " + media.getPrice().getPriceID() + ", " + 
						media.getFormat().getFormatID());
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
		return media;
	}
	
	/**
	 * Retrieves all the copies associated with a media
	 * @param media_ID the media's ID number
	 * @return a list of media copies
	 * @throws SQLException if there is an error
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static MediaCopy[] getMediaCopiesQuery(int mediaID) throws SQLException, FileNotFoundException, IOException
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		MediaCopy[] mediaCopies = null;
		//MediaCopy mediaCopy = new MediaCopy();
		int totalRows;
		int row = 0;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaCopies_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, mediaID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			totalRows = getNumberOfRows(myRs);
			
			//Creates an array of MediaCopy with the size of total rows from the result set
			mediaCopies = new MediaCopy[totalRows];
			generateMediaCopies(mediaCopies);
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				mediaCopies[row].setMediaCopyId(myRs.getInt("copy_ID"));
				mediaCopies[row].setRented(myRs.getBoolean("rental_status"));
				mediaCopies[row].setReserved(myRs.getBoolean("reservation_status"));
				mediaCopies[row].setState(myRs.getString("state"));
				mediaCopies[row].setActive(myRs.getBoolean("active"));
				mediaCopies[row].setMediaId(myRs.getInt("media_ID"));
				
				System.out.println(mediaCopies[row].getMediaCopyId() + ", " + mediaCopies[row].isRented() + ", " + mediaCopies[row].isReserved() + 
						", " + mediaCopies[row].getState() + ", " + mediaCopies[row].isActive() + ", " + mediaCopies[row].getMediaId());
				row++;
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
		return mediaCopies;
	}
	
	/**
	 * Retrieves a media copy from the database
	 * @param copy_ID the media copy's ID number
	 * @return the MediaCopy object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static MediaCopy getMediaCopyQuery(int copyID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		MediaCopy mediaCopy = new MediaCopy();
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaCopies_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, copyID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				mediaCopy.setMediaCopyId(myRs.getInt("copy_ID"));
				mediaCopy.setRented(myRs.getBoolean("rental_status"));
				mediaCopy.setReserved(myRs.getBoolean("reservation_status"));
				mediaCopy.setState(myRs.getString("state"));
				mediaCopy.setActive(myRs.getBoolean("active"));
				mediaCopy.setMediaId(myRs.getInt("media_ID"));
				
				System.out.println(mediaCopy.getMediaCopyId() + ", " + mediaCopy.isRented() + ", " + mediaCopy.isReserved() + 
						", " + mediaCopy.getState() + ", " + mediaCopy.isActive() + ", " + mediaCopy.getMediaId());
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
		return mediaCopy;
	}
	
	/**
	 * Retrieves a tv show disk from the database
	 * @param media_ID the tv show disk's ID number
	 * @return the TVShowDisk object or NULL
	 */
	public TvShowDisk getTVShowDiskQuery(int mediaID) 
	{
		return null;
	}
	
	/**
	 * Retrieves a rental from the database
	 * @param rental_ID the rental's ID number
	 * @return the Rental object or NULL
	 */
	public Rental getRentalQuery(int rentalID) 
	{
		return null;
	}
	
	/**
	 * Retrieves a reservation from the database
	 * @param reservation_ID the reservation's ID number
	 * @return the Reservation object or NULL
	 */
	public Reservation getReservationQuery(int reservationID) 
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
		Account account = new Account();
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
						
			//Loops through the result set and sets all the properties to the corresponding object variables
			while (myRs.next()) {
				
				//Account myAccount = new Account();
				account.setAccountID(myRs.getInt("account_ID"));
				account.setFirstName(myRs.getString("first_name"));
				account.setLastName(myRs.getString("last_name"));
				account.setPhoneNumber(myRs.getString("phone"));
				account.setEmail(myRs.getString("email"));
				account.setProvince(myRs.getString("province"));
				account.setCity(myRs.getString("city"));
				account.setPostalCode(myRs.getString("postal_code"));
				account.setCountry(myRs.getString("country"));
				account.setStreetName(myRs.getString("street_name"));
				account.setApartmentNumber(myRs.getInt("apt_number"));
				account.setStreetNumber(myRs.getInt("street_number"));
				account.setAccountType(myRs.getString("type"));
				account.setStatus(myRs.getString("status"));
				account.setBalanceOwed(myRs.getDouble("balance"));
				account.setPassword(myRs.getString("password"));
				account.setPassPhrase(myRs.getString("passphrase"));
								
				System.out.println(account.getAccountID() + ", " + account.getFirstName() + ", " + account.getLastName() +
						", " + account.getPhoneNumber() + ", " + account.getEmail());
				
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
	
	/**
	 * Gets the number of rows in a ResultSet
	 * @param myRs a result set from a query
	 * @return the total number of rows in a result set
	 * @throws SQLException
	 */
	public static int getNumberOfRows(ResultSet myRs) throws SQLException{
		int totalRows = 0;
		
		//Moves the cursor to the last row of the result set to get the size
		if(myRs.last()){
			totalRows = myRs.getRow();
			System.out.println(totalRows);
			//Moves the cursor back to the first row
			myRs.beforeFirst();
		}

		return totalRows;
	}
	
	/**
	 * Fills an array of MediaCopy with default MediaCopy objects.
	 * @param mediaCopies an array of MediaCopy
	 * @return the array of MediaCopy
	 * @precondition the array must have a set size
	 * @postcondition the array must be filled with media copy objects
	 */
	public static MediaCopy[] generateMediaCopies(MediaCopy[] mediaCopies){
		
		for(int i = 0; i < mediaCopies.length; i++){
			mediaCopies[i] = new MediaCopy();
		}
		
		return mediaCopies;
	}
}
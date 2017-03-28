package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.nexvid.accounts.*;

/**
 * This class adds new entries to the database using INSERT queries
 * @author Russell Hanson
 * @author Juan Carlos Pinillos
 */
public class DBAdder
{
	/**
	 * Adds an account to the database
	 * @param account a new Account object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the account does not already exist
	 * @postcondition an account is added to the database
	 */
	public static void addNewAccountQuery(Account account) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setString(1, account.getFirstName());
			myStmt.setString(2, account.getLastName());
			myStmt.setString(3, account.getPhoneNumber());
			myStmt.setString(4, account.getEmail());
			myStmt.setString(5, account.getProvince());
			myStmt.setString(6, account.getCity());
			myStmt.setString(7, account.getPostalCode());
			myStmt.setString(8, account.getCountry());
			myStmt.setString(9, account.getStreetName());
			myStmt.setInt(10, account.getAppartmentNumber());
			myStmt.setInt(11, account.getStreetNumber());
			myStmt.setString(12, account.getAccountType());
			myStmt.setString(13, account.getStatus());
			myStmt.setDouble(14, account.getBalanceOwed());
			myStmt.setString(15, account.getPassword());
			myStmt.setString(16, account.getPassPhrase());
			
			System.out.println("Was the media successfulling inserted: " + myStmt.executeUpdate());
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				System.out.println("Was connection closed: " + db.endConnection(myConn)); //Closes the connection
			}
		}

	}
		
	/**
	 * Adds a new sub account to the database
	 * @param subAccont a new SubAccount object
	 * @precondition the sub-account does not already exist
	 * @postcondition a sub-account is added to the database
	 */
	public void addNewSubAccountQuery(SubAccount subAccount){

	}
	
	/**
	 * Adds a new media to the database
	 * @param media a new Media object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the media does not already exist
	 * @postcondition a media is added to the database
	 */
	public static void addNewMediaQuery(Media media) throws FileNotFoundException, IOException, SQLException{		
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_media(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setString(1, media.getTitle());
			myStmt.setInt(2, media.getTimesRented());
			myStmt.setInt(3, media.getOnlineID());
			myStmt.setString(4, media.getType());
			myStmt.setInt(5, media.getPrice().getPriceID());
			myStmt.setInt(6, media.getFormat().getFormatID());
			
			System.out.println("Was the media successfulling inserted: " + myStmt.executeUpdate());
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				System.out.println("Was connection closed: " + db.endConnection(myConn)); //Closes the connection
			}
		}
		
		
	}
	
	/**
	 * Adds a media copy to the database
	 * @param mediaCopy a new MediaCopy object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @postcondition a media copy is added to the database
	 */
	public static void addMediaCopyQuery(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_mediaCopy(?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setBoolean(1, mediaCopy.isRented());
			myStmt.setBoolean(2, mediaCopy.isReserved());
			myStmt.setString(3, mediaCopy.getState());
			myStmt.setBoolean(4, mediaCopy.isActive);
			myStmt.setInt(5, mediaCopy.getMediaId());
			
			System.out.println("Was the media copy successfulling inserted: " + myStmt.executeUpdate());
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				System.out.println("Was connection closed: " + db.endConnection(myConn)); //Closes the connection
			}
		}

	}
	
	/**
	 * Adds a new rental to the database
	 * @param rental a new Rental object
	 * @precondition an account matching the account_ID exists in the database
	 * @precondition a media copy matching the copy_ID exists in the database
	 * @postcondition a rental is added to the database
	 */
	public void addNewRentalQuery(Rental rental) {
		
	}
	
	/**
	 * Adds a reservation to the database
	 * @param reservation a new Reservation object
	 * @precondition an account matching the account_ID exists in the database
	 * @precondition a media copy matching the copy_ID exists in the database
	 * @postcondition a reservation is added to the database
	 */
	public void addNewReservationQuery(Reservation reservation) {
		
	}
	
	/**
	 * Adds a new format to the database
	 * @param format a new Format
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @precondition the format does not already exist
	 * @postcondition a new format is added to the database
	 */
	public static void addNewFormatQuery(Format format) throws SQLException, FileNotFoundException, IOException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_format(?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setString(1, format.getType());
			
			System.out.println("Was the format successfulling inserted: " + myStmt.executeUpdate());
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				System.out.println("Was connection closed: " + db.endConnection(myConn)); //Closes the connection
			}
		}
	}
	
	/**
	 * Adds a new price tier to the database
	 * @param pricetier
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the price tier does not already exist
	 * @postcondition the new price tier is added to the database
	 */
	public static void addNewPriceTier(PriceTier priceTier) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_price_tier(?, ?, ?}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, priceTier.getRentalPeriod());
			myStmt.setString(2, priceTier.getPriceTier());
			myStmt.setDouble(3, priceTier.getPrice());
			
			System.out.println("Was the price tier successfulling inserted: " + myStmt.executeUpdate());
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				System.out.println("Was connection closed: " + db.endConnection(myConn)); //Closes the connection
			}
		}

	}
}
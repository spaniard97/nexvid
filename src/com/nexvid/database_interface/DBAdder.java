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
	 * @precondition the account does not already exist
	 * @postcondition an account is added to the database
	 */
	public void addNewAccountQuery(Account account){
		
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
	 * @precondition the format does not already exist
	 * @postcondition a new format is added to the database
	 */
	public void addNewFormatQuery(Format format){
		
	}
	
	/**
	 * Adds a new price tier to the database
	 * @param pricetier
	 * @precondition the price tier does not already exist
	 * @postcondition the new price tier is added to the database
	 */
	public void addNewPriceTier(PriceTier pricetier){
		
	}
}
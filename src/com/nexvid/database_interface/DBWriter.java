package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import com.nexvid.accounts.*;

/**
 * This class writes data to the database using UPDATE queries
 * @author Juan Carlos Pinillos
 * @author Russell Hanson
 */
public class DBWriter {
	
	/**
	 * Receives an Account object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param account an Account object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an account matching an account record that exists in the database by account_ID
	 * @postcondition the matching account is modified in the database
	 */
	public static void setAccountQuery(Account account) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_account_info(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, account.getAccountID());
			myStmt.setString(2, account.getFirstName());
			myStmt.setString(3, account.getLastName());
			myStmt.setString(4, account.getPhoneNumber());
			checkNull(myStmt, 5, account.getEmail());
			myStmt.setString(6, account.getProvince());
			myStmt.setString(7, account.getCity());
			myStmt.setString(8, account.getPostalCode());
			myStmt.setString(9, account.getCountry());
			myStmt.setString(10, account.getStreetName());
			checkNull(myStmt, 11, account.getAppartmentNumber());
			myStmt.setInt(12, account.getStreetNumber());
			myStmt.setString(13, account.getAccountType());
			myStmt.setString(14, account.getStatus());
			myStmt.setDouble(15, account.getBalanceOwed());
			myStmt.setString(16, account.getPassword());
			checkNull(myStmt, 17, account.getPassPhrase());
			
			System.out.println("Was the Account successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a SubAccount object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param subAccount a subAccount object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a subAccount matching a subAccount record that exists in the database by sub_ID
	 * @postcondition the matching subAccount is modified in the database 
	 */
	public void setSubAccountQuery(SubAccount subAccount) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_subAccount(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, subAccount.getSubAccountID());
			myStmt.setDate(2, (Date) subAccount.getDateOfBirth());
			myStmt.setString(3, subAccount.getFirstName());
			myStmt.setString(4, subAccount.getLastName());
			myStmt.setBoolean(5, subAccount.isActive());
			myStmt.setInt(6, subAccount.getAccount().getAccountID());
			
			System.out.println("Was the Sub Account successfulling inserted: " + myStmt.executeUpdate());
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
	 * Receives a Media object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param media a Media object
	 * @precondition a media matching a media record that exists in the database by media_ID
	 * @postcondition the matching media is modified in the database 
	 */
	public void setMediaQuery(Media media){
		
	}
	
	/**
	 * Receives a MediaCopy object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param mediaCopy a MediaCopy object
	 * @precondition a mediaCopy matching a mediaCopy record that exists in the database by copy_ID
	 * @postcondition the matching mediaCopy is modified in the database 
	 */
	public void setMediaCopyQuery(MediaCopy mediaCopy){
		
	}
	
	/**
	 * Receives a PriceTier object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param priceTier a PriceTier object
	 * @precondition a priceTier matching a priceTier record that exists in the database by price_ID
	 * @postcondition the matching priceTier is modified in the database 
	 */
	public void setPriceTierQuery(PriceTier priceTier){
		
	}
	
	/**
	 * Receives a Format object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param format a Format object
	 * @precondition a format matching a format record that exists in the database by format_ID
	 * @postcondition the matching format is modified in the database 
	 */
	public void setFormatQuery(Format format){
		
	}
	
	/**
	 * Receives a Rental object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param rental a Rental object
	 * @precondition a rental matching a rental record that exists in the database by rental_ID
	 * @postcondition the matching rental is modified in the database 
	 */
	public void setRentalQuery(Rental rental){
		
	}
	
	/**
	 * Receives a Reservation object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param reservation a Reservation Object
	 * @precondition a reservation matching a reservation record that exists in the database by reservation_ID
	 * @postcondition the matching reservation is modified in the database 
	 */
	public void setReservation(Reservation reservation){
		
	}
	
	/**
	 * Receives a TVShowDisk object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param tvShowDisk a TVShowDisk Object
	 * @precondition a tvShowDisk matching a tvShowDisk record that exists in the database by season_number, disk_number, and media_ID
	 * @postcondition the matching tvShowDisk is modified in the database 
	 */
	public void setTVShowDisk(TvShowDisk tvShowDisk){
		
	}
	
	/**
	 * Checks if a property should be inserted as NULL
	 * @param myStmt the callable statement from a query
	 * @param position the position of the property in the query
	 * @param number the value of the property
	 * @throws SQLException
	 */
	protected static void checkNull(CallableStatement myStmt, int position, int number) throws SQLException{
		if(number == 0)
			myStmt.setNull(position, Types.INTEGER);
		else
			myStmt.setInt(position, number);
	}
	
	/**
	 * Checks if a property should be inserted as NULL
	 * @param myStmt the callable statement from a query
	 * @param position the position of the property in the query
	 * @param value the value of the property
	 * @throws SQLException
	 */
	protected static void checkNull(CallableStatement myStmt, int position, String value) throws SQLException{
		if(value == null)
			myStmt.setNull(position, Types.VARCHAR);
		else
			myStmt.setString(position, value);
	}

}

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
 * This class adds new entries to the database using INSERT queries
 * @author Russell Hanson
 * @author Juan Carlos Pinillos
 */
public class DBAdder
{
	/**
	 * Adds an account to the database
	 * @param account a new Account object
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the account does not already exist
	 * @postcondition an account is added to the database
	 */
	public static int addNewAccountQuery(Account account) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int accountID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setString(1, account.getFirstName());
			myStmt.setString(2, account.getLastName());
			myStmt.setString(3, account.getPhoneNumber());
			checkNull(myStmt, 4, account.getEmail());
			myStmt.setString(5, account.getProvince());
			myStmt.setString(6, account.getCity());
			myStmt.setString(7, account.getPostalCode());
			myStmt.setString(8, account.getCountry());
			myStmt.setString(9, account.getStreetName());
			checkNull(myStmt, 10, account.getApartmentNumber());
			myStmt.setInt(11, account.getStreetNumber());
			myStmt.setString(12, account.getAccountType());
			myStmt.setString(13, account.getStatus());
			myStmt.setDouble(14, account.getBalanceOwed());
			myStmt.setString(15, account.getPassword());
			myStmt.setString(16, account.getPassPhrase());
			myStmt.registerOutParameter(17, Types.INTEGER);

			//Execute the query to the database
			myStmt.execute();
			accountID = myStmt.getInt("the_id");
		}
		
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return accountID;
		
	}
		
	/**
	 * Adds a new sub account to the database
	 * @param subAccont a new SubAccount object
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the sub-account does not already exist
	 * @postcondition a sub-account is added to the database
	 */
	public static int addNewSubAccountQuery(SubAccount subAccount) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int subID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_subAccount(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setDate(1, (Date) subAccount.getDateOfBirth());
			myStmt.setString(2, subAccount.getFirstName());
			myStmt.setString(3, subAccount.getLastName());
			myStmt.setBoolean(4, subAccount.isActive());
			myStmt.setInt(5, subAccount.getAccount().getAccountID());
			myStmt.registerOutParameter(6, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			subID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return subID;
	}

	
	/**
	 * Adds a new media to the database
	 * @param media a new Media object
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the media does not already exist
	 * @postcondition a media is added to the database
	 */
	public static int addNewMediaQuery(Media media) throws FileNotFoundException, IOException, SQLException{		
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int mediaID = 0;
		
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_media(?,?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setString(1, media.getTitle());
			myStmt.setInt(2, media.getTimesRented());
			myStmt.setInt(3, media.getOnlineID());
			myStmt.setString(4, media.getType());
			myStmt.setInt(5, media.getPrice().getPriceID());
			myStmt.setInt(6, media.getFormat().getFormatID());
			myStmt.registerOutParameter(7, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			mediaID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null){
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return mediaID;
	}
	
	/**
	 * Adds a media copy to the database
	 * @param mediaCopy a new MediaCopy object
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @postcondition a media copy is added to the database
	 */

	public static int addMediaCopyQuery(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int copyID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_mediaCopy(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setBoolean(1, mediaCopy.isRented());
			myStmt.setBoolean(2, mediaCopy.isReserved());
			myStmt.setString(3, mediaCopy.getState());
			myStmt.setBoolean(4, mediaCopy.isActive());
			myStmt.setInt(5, mediaCopy.getMediaId());
			myStmt.registerOutParameter(6, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			copyID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return copyID;
	}
	
	/**
	 * Adds the TV Show disk information to the database
	 * @param tvShow a TvShowDisk object that has specific disk information
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static void addTvShowDiskQuery(TvShowDisk tvShow) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_tvShowDisk(?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, tvShow.getSeasonNumber());
			myStmt.setInt(2, tvShow.getNumberOfEpisodes());
			myStmt.setInt(3, tvShow.getDiskNumber());
			myStmt.setInt(4, tvShow.getMediaCopyId());

			
			//Execute the query to the database
			myStmt.executeUpdate();
		}
		finally{			
			if (myStmt != null){
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
	}

	/**
	 * Adds a new rental to the database
	 * @param rental a new Rental object
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an account matching the account_ID exists in the database
	 * @precondition a media copy matching the copy_ID exists in the database
	 * @postcondition a rental is added to the database
	 */
	public static int addNewRentalQuery(Rental rental) throws FileNotFoundException, IOException, SQLException {
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int rentalID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_rental(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setDate(1, rental.getDateRented());
			myStmt.setDate(2, rental.getDateDue());
			myStmt.setBoolean(3, rental.isActive());
			myStmt.setInt(4, rental.getAccount().getAccountID());
			myStmt.setInt(5, rental.getMediaCopy().getMediaCopyId());
			myStmt.registerOutParameter(6, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			rentalID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return rentalID;
	}

	
	/**
	 * Adds a reservation to the database
	 * @param reservation a new Reservation object
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an account matching the account_ID exists in the database
	 * @precondition a media copy matching the copy_ID exists in the database
	 * @postcondition a reservation is added to the database
	 */
	public static int addNewReservationQuery(Reservation reservation) throws FileNotFoundException, IOException, SQLException {
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int reservationID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_reservation(?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setDate(1, reservation.getReservationDate());
			myStmt.setBoolean(2, reservation.isReservationActive());
			myStmt.setInt(3, reservation.getCustomerAccount().getAccountID());
			myStmt.setInt(4, reservation.getMediaCopy().getMediaCopyId());
			myStmt.registerOutParameter(5, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			reservationID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return reservationID;
	}
	
	/**
	 * Adds a new format to the database
	 * @param format a new Format
	 * @return the ID generated by the database
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @precondition the format does not already exist
	 * @postcondition a new format is added to the database
	 */
	public static int addNewFormatQuery(Format format) throws SQLException, FileNotFoundException, IOException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int formatID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_format(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setString(1, format.getType());
			myStmt.registerOutParameter(2, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			formatID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return formatID;
	}
	
	/**
	 * Adds a new price tier to the database
	 * @param pricetier
	 * @return the ID generated by the database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition the price tier does not already exist
	 * @postcondition the new price tier is added to the database
	 */
	public static int addNewPriceTier(PriceTier priceTier) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		int priceID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call insert_price_tier(?,?,?,?}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, priceTier.getRentalPeriod());
			myStmt.setString(2, priceTier.getPriceTier());
			myStmt.setDouble(3, priceTier.getPrice());
			myStmt.registerOutParameter(4, Types.INTEGER);
			
			//Execute the query to the database
			myStmt.execute();
			priceID = myStmt.getInt("the_id");
		}
		finally{			
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null){
				db.endConnection(myConn); //Closes the connection
			}
		}
		return priceID;
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
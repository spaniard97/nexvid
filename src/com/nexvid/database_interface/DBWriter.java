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
			checkNull(myStmt, 11, account.getApartmentNumber());
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
	 * 
	 * @param account
	 * @throws SQLException 
	 */
	public static void setAccountBalance(Account account) throws SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_account_balance(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, account.getAccountID());
			myStmt.setDouble(2, account.getBalanceOwed());
			
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
	public static void setSubAccountQuery(SubAccount subAccount) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_subAccount_info(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, subAccount.getSubAccountID());
			myStmt.setDate(2, (Date) subAccount.getDateOfBirth());
			myStmt.setString(3, subAccount.getFirstName());
			myStmt.setString(4, subAccount.getLastName());
			myStmt.setBoolean(5, subAccount.isActive());
			myStmt.setInt(6, subAccount.getAccount().getAccountID());
			
			System.out.println("Was the Sub Account successfulling updated: " + myStmt.executeUpdate());
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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a media matching a media record that exists in the database by media_ID
	 * @postcondition the matching media is modified in the database 
	 */
	public static void setMediaQuery(Media media) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_media_info(?,?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, media.getMediaId());
			myStmt.setString(2, media.getTitle());
			myStmt.setInt(3, media.getTimesRented());
			myStmt.setInt(4, media.getOnlineID());
			myStmt.setString(5, media.getType());
			myStmt.setInt(6, media.getPrice().getPriceID());
			myStmt.setInt(7, media.getFormat().getFormatID());
			
			System.out.println("Was the media successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a MediaCopy object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param mediaCopy a MediaCopy object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a mediaCopy matching a mediaCopy record that exists in the database by copy_ID
	 * @postcondition the matching mediaCopy is modified in the database 
	 */
	public static void setMediaCopyQuery(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_mediaCopy_info(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1,  mediaCopy.getMediaCopyId());
			myStmt.setBoolean(2, mediaCopy.isRented());
			myStmt.setBoolean(3, mediaCopy.isReserved());
			myStmt.setString(4, mediaCopy.getState());
			myStmt.setBoolean(5, mediaCopy.isActive());
			myStmt.setInt(6, mediaCopy.getMediaId());
			
			System.out.println("Was the media copy successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a PriceTier object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param priceTier a PriceTier object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a priceTier matching a priceTier record that exists in the database by price_ID
	 * @postcondition the matching priceTier is modified in the database 
	 */
	public static void setPriceTierQuery(PriceTier priceTier) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_price_tier_info(?,?,?}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, priceTier.getPriceID());
			myStmt.setInt(2, priceTier.getRentalPeriod());
			myStmt.setString(3, priceTier.getPriceTier());
			//myStmt.setDouble(4, priceTier.getPrice());
			
			System.out.println("Was the price tier successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a Format object that already exists in the database, then writes to the database.
	 * This is used to modify the record.
	 * @param format a Format object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a format matching a format record that exists in the database by format_ID
	 * @postcondition the matching format is modified in the database 
	 */
	public static void setFormatQuery(Format format) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_format_info(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, format.getFormatID());
			myStmt.setString(2, format.getType());
			
			System.out.println("Was the format successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a Rental object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param rental a Rental object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a rental matching a rental record that exists in the database by rental_ID
	 * @postcondition the matching rental is modified in the database 
	 */
	public static void setRentalQuery(Rental rental) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_rental_info(?,?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, rental.getRentalID());
			myStmt.setDate(2, rental.getDateRented());
			myStmt.setDate(3, rental.getDateDue());
			myStmt.setBoolean(4, rental.isActive());
			myStmt.setInt(5, rental.getAccount().getAccountID());
			myStmt.setInt(6, rental.getMediaCopy().getMediaCopyId());

			
			System.out.println("Was the rental successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a Reservation object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param reservation a Reservation Object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a reservation matching a reservation record that exists in the database by reservation_ID
	 * @postcondition the matching reservation is modified in the database 
	 */
	public static void setReservation(Reservation reservation) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call update_reservation_info(?,?,?,?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, reservation.getReservationId());
			myStmt.setDate(2, reservation.getReservationDate());
			myStmt.setBoolean(3, reservation.isReservationActive());
			myStmt.setInt(4, reservation.getCustomerAccount().getAccountID());
			myStmt.setInt(5, reservation.getMediaCopy().getMediaCopyId());
			
			System.out.println("Was the Reservation successfulling updated: " + myStmt.executeUpdate());
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
	 * Receives a TVShowDisk object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param tvShowDisk a TVShowDisk Object
	 * @precondition a tvShowDisk matching a tvShowDisk record that exists in the database by season_number, disk_number, and media_ID
	 * @postcondition the matching tvShowDisk is modified in the database 
	 */
	public void setTVShowDisk(TvShowDisk tvShowDisk){
		
	}

	/**
	 * Receives a Account object that already exists in the database and changes the status.
	 * This is used to modify the record. 
	 * @param account a Account object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an account matching a account record that exists in the database by account_ID
	 * @postcondition the matching account has its status changed 
	 */
	public static void changeStatus(Account account) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call change_account_status(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, account.getAccountID());
			myStmt.setString(2, account.getStatus());

			System.out.println("Was the account status successfulling changed: " + myStmt.executeUpdate());
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
	 * Receives a SubAccount object that already exists in the database and deactivates it.
	 * This is used to modify the record. 
	 * @param subAccount a SubAccount object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a subAccount matching a sub account record that exists in the database by sub_ID
	 * @postcondition the matching sub account is deactivated
	 */
	public static void deactivate(SubAccount subAccount) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call deactivate_subAccount(?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, subAccount.getSubAccountID());

			System.out.println("Was the sub account successfulling deactivated: " + myStmt.executeUpdate());
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
	 * Receives a MediaCopy object that already exists in the database and changes its state.
	 * This is used to modify the record. 
	 * @param mediaCopy a MediaCopy object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a mediaCopy matching a media copy record that exists in the database by copy_ID
	 * @precondition the status must match one of the database predetermined states: "New", "Good", "Fair", "Damaged".
	 * @postcondition the matching media copy has its status changed 
	 */
	public static void changeState(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call change_mediaCopy_state(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, mediaCopy.getMediaCopyId());
			myStmt.setString(2, mediaCopy.getState());

			System.out.println("Was the media copy's state successfulling changed: " + myStmt.executeUpdate());
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
	 * Receives a MediaCopy object that already exists in the database and deactivates it.
	 * This is used to modify the record. 
	 * @param mediaCopy a MediaCopy object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a mediaCopy matching a media copy record that exists in the database by copy_ID
	 * @postcondition the matching media copy is deactivated 
	 */
	public static void deactivate(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call deactivate_mediaCopy(?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, mediaCopy.getMediaCopyId());

			System.out.println("Was the media copy successfulling deactivated: " + myStmt.executeUpdate());
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
	 * Receives a MediaCopy object that already exists in the database and changes the rental status.
	 * This is used to modify the record. 
	 * @param mediaCopy a MediaCopy object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a mediaCopy matching a media copy record that exists in the database by copy_ID
	 * @postcondition the matching media copy has its rental status changed
	 */
	public static void changeRentStatus(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call change_mediaCopy_rental_status(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, mediaCopy.getMediaCopyId());
			myStmt.setBoolean(2, mediaCopy.isRented());

			System.out.println("Was the media copy's rental status successfulling changed: " + myStmt.executeUpdate());
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
	 * Receives a MediaCopy object that already exists in the database and changes the reservation status.
	 * This is used to modify the record. 
	 * @param mediaCopy a MediaCopy object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a mediaCopy matching a media copy record that exists in the database by copy_ID
	 * @postcondition the matching media copy has its reservation status changed
	 */
	public static void changeReserveStatus(MediaCopy mediaCopy) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call change_mediaCopy_reservation_status(?,?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, mediaCopy.getMediaCopyId());
			myStmt.setBoolean(2, mediaCopy.isReserved());

			System.out.println("Was the media copy's reservation status successfulling changed: " + myStmt.executeUpdate());
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
	 * Receives a Rental object that already exists in the database and deactivates it.
	 * This is used to modify the record. 
	 * @param rental a Rental object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a rental matching a rental record that exists in the database by rental_ID
	 * @postcondition the matching rental is deactivated 
	 */
	public static void deactivate(Rental rental) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call deactivate_rental(?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, rental.getRentalID());

			System.out.println("Was the rental successfulling deactivated: " + myStmt.executeUpdate());
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
	 * Receives a Reservation object that already exists in the database and deactivates it.
	 * This is used to modify the record. 
	 * @param reservation a Reservation object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition a reservation matching a reservation record that exists in the database by reservation_ID
	 * @postcondition the matching reservation is deactivated 
	 */
	public static void deactivate(Reservation reservation) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call deactivate_reservation(?)}");
			
			//Fills in the query with the corresponding parameters
			myStmt.setInt(1, reservation.getReservationId());

			System.out.println("Was the reservation successfulling deactivated: " + myStmt.executeUpdate());
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
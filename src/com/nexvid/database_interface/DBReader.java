package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;
import com.nexvid.accounts.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class reads data from the database using SELECT queries
 * @author Juan Carlos Pinillos
 * @author Russell Hanson
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
	 * @precondition an integer greater than 0 for the account id
	 * @postcondition an account object with either the account information for a found account or with null values.
	 */
	public static Account getAccountQuery(int accountID) throws SQLException, FileNotFoundException, IOException 
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
				
				//For Testing.  Comment out later.
				//System.out.println(account.getAccountID() + ", " + account.getFirstName() + ", " + account.getLastName() +
				//		", " + account.getPhoneNumber() + ", " + account.getEmail());
				
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
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
	 * @precondition an integer greater than 0 for the sub id
	 * @postcondition a sub account object with either the sub account information for a found sub account or with null values.
	 */
	public static SubAccount getSubAccountQuery(int subID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		SubAccount subAccount = new SubAccount();
		int accountID;
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
				accountID = myRs.getInt("account_ID");
				subAccount.setAccount(DBReader.getAccountQuery(accountID));			
				
				//For Testing.  Comment out later.
				/*System.out.println(subAccount.getSubAccountID() + ", " + subAccount.getDateOfBirth() + ", " + subAccount.getFirstName() + ", " + subAccount.getLastName() + 
						", " + subAccount.isActive() + ", " + subAccount.getAccount().getAccountID());*/
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
		}
		return subAccount;
	}

	/**
	 * Retrieves a media from the database
	 * @param onlineID the media's online ID number
	 * @return the Media object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the online id
	 * @postcondition a media object with either the media information for a found media or with null values.
	 */
	public static Media getMediaQuery(int onlineID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Media media = new Media();
		
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
				media.setPrice(DBReader.getPriceTier(myRs.getInt("price_ID")));
				media.setFormat(DBReader.getFormat(myRs.getInt("format_ID")));
				
				//For Testing.  Comment out later.
				/*System.out.println(media.getMediaId() + ", " + media.getTitle() + ", " + media.getTimesRented() + 
						", " + media.getOnlineID() + ", " + media.getType() + ", " + media.getPrice().getPriceID() + ", " + 
						media.getFormat().getFormatID());
			*/
			}
			
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
		}
		return media;
	}
	
	/**
	 * Retrieves a media from the database by media ID
	 * @param mediaID the media's database ID number
	 * @return the Media object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the media ID
	 * @postcondition a media object with either the media information for a found media or with null values.
	 */
	public static Media getMediaByMediaIDQuery(int mediaID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Media media = new Media();
		
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaById_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, mediaID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				media.setMediaId(myRs.getInt("media_ID"));
				media.setTitle(myRs.getString("title"));
				media.setTimesRented(myRs.getInt("times_rented"));
				media.setOnlineID(myRs.getInt("online_ID"));
				media.setType(myRs.getString("type"));
				media.setPrice(DBReader.getPriceTier(myRs.getInt("price_ID")));
				media.setFormat(DBReader.getFormat(myRs.getInt("format_ID")));
				
				//For Testing.  Comment out later.
				/*System.out.println(media.getMediaId() + ", " + media.getTitle() + ", " + media.getTimesRented() + 
						", " + media.getOnlineID() + ", " + media.getType() + ", " + media.getPrice().getPriceID() + ", " + 
						media.getFormat().getFormatID());*/
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
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
	 * @precondition an integer greater than 0 for the media id
	 * @postcondition an array of media copy objects with either the copies information for a found copy or with null values.
	 */
	public static ArrayList<MediaCopy> getMediaCopiesQuery(int mediaID) throws SQLException, FileNotFoundException, IOException
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		ArrayList<MediaCopy> mediaCopies = null;
		Media media = null;
		MediaCopy mediaCopy = null;
		PriceTier price = null;
		Format format = null;
		int row = 0;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			mediaCopies = new ArrayList<MediaCopy>();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaCopies_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, mediaID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Gets the total number of rows from the result set
			//totalRows = getNumberOfRows(myRs);
			
			//Creates an array of MediaCopy with the size of total rows from the result set
			//mediaCopies = new MediaCopy[totalRows];
			//generateMediaCopies(mediaCopies);
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				mediaCopy = new MediaCopy();
				mediaCopy.setMediaCopyId(myRs.getInt("copy_ID"));
				mediaCopy.setRented(myRs.getBoolean("rental_status"));
				mediaCopy.setReserved(myRs.getBoolean("reservation_status"));
				mediaCopy.setState(myRs.getString("state"));
				mediaCopy.setActive(myRs.getBoolean("active"));
				mediaCopy.setMediaId(myRs.getInt("media_ID"));
				media = DBReader.getMediaByMediaIDQuery(mediaCopy.getMediaId());
				mediaCopy.setTitle(media.getTitle());
				mediaCopy.setTimesRented(media.getTimesRented());
				mediaCopy.setOnlineID(media.getOnlineID());
				mediaCopy.setType(media.getType());
				price = DBReader.getPriceTier(media.getPrice().getPriceID());
				mediaCopy.setPrice(price);
				format = DBReader.getFormat(media.getFormat().getFormatID());
				mediaCopy.setFormat(format);
				mediaCopies.add(mediaCopy);
				
				
				//For Testing.  Comment out later.
				//System.out.println(mediaCopies.get(row).getMediaCopyId() + ", " + mediaCopies.get(row).isRented() + ", " + mediaCopies.get(row).isReserved() + 
					//	", " + mediaCopies.get(row).getState() + ", " + mediaCopies.get(row).isActive() + ", " + mediaCopies.get(row).getMediaId());
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
			db.endConnection(myConn); //Closes the connection
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
	 * @precondition an integer greater than 0 for the copy id
	 * @postcondition a media copy object with either the media copy information for a found media copy or with null values.
	 */
	public static MediaCopy getMediaCopyQuery(int copyID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		MediaCopy mediaCopy = new MediaCopy();
		Media media = null;
		PriceTier price = null;
		Format format = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_mediaCopy_info(?)}");
			
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
				
				//For Testing.  Comment out later.
				//System.out.println(mediaCopy.getMediaCopyId() + ", " + mediaCopy.isRented() + ", " + mediaCopy.isReserved() + 
						//", " + mediaCopy.getState() + ", " + mediaCopy.isActive() + ", " + mediaCopy.getMediaId());
			}
			media = DBReader.getMediaByMediaIDQuery(mediaCopy.getMediaId());
			mediaCopy.setTitle(media.getTitle());
			mediaCopy.setTimesRented(media.getTimesRented());
			mediaCopy.setOnlineID(media.getOnlineID());
			mediaCopy.setType(media.getType());
			price = DBReader.getPriceTier(media.getPrice().getPriceID());
			mediaCopy.setPrice(price);
			format = DBReader.getFormat(media.getFormat().getFormatID());
			mediaCopy.setFormat(format);

		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
		}
		return mediaCopy;
	}
	
	/**
	 * Retrieves a tv show disk from the database
	 * @param media_ID the tv show disk's ID number
	 * @return the TVShowDisk object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static TvShowDisk getTVShowDiskQuery(int copyID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		TvShowDisk tvShow = null;
		Media media = null;
		MediaCopy copy = null;
		PriceTier price = null;
		Format format = null;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			tvShow = new TvShowDisk();
			media = new Media();
			copy = new MediaCopy();
			price = new PriceTier();
			format = new Format();
			
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_tvShowDisk_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, copyID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				tvShow.setSeasonNumber(myRs.getInt("season_number"));
				tvShow.setNumberOfEpisodes(myRs.getInt("number_of_episodes"));
				tvShow.setDiskNumber(myRs.getInt("disk_number"));
				tvShow.setMediaCopyId(myRs.getInt("copy_ID"));
				
			}
			copy = DBReader.getMediaCopyQuery(tvShow.getMediaCopyId());
			tvShow.setRented(copy.isRented());
			tvShow.setReserved(copy.isReserved());
			tvShow.setState(copy.getState());
			tvShow.setActive(copy.isActive());
			tvShow.setMediaId(copy.getMediaId());
			media = DBReader.getMediaByMediaIDQuery(tvShow.getMediaId());
			tvShow.setTitle(media.getTitle());
			tvShow.setTimesRented(media.getTimesRented());
			tvShow.setOnlineID(media.getOnlineID());
			tvShow.setType(media.getType());
			price = DBReader.getPriceTier(media.getPrice().getPriceID());
			tvShow.setPrice(price);
			format = DBReader.getFormat(media.getFormat().getFormatID());
			tvShow.setFormat(format);
			
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
		}
		return tvShow;
	}
	
	/**
	 * Retrieves a rental from the database
	 * @param rental_ID the rental's ID number
	 * @return the Rental object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the rental id
	 * @postcondition a rental object with either the rental information for a found rental or with null values.
	 */
	public static Rental getRentalQuery(int rentalID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Rental rental = new Rental();
		int accountID;
		int copyID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_rental_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, rentalID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				rental.setRentalID(myRs.getInt("rental_ID"));
				rental.setDateRented(myRs.getDate("date_rented"));
				rental.setDateDue(myRs.getDate("date_due"));
				rental.setActive(myRs.getBoolean("active"));
				accountID = myRs.getInt("account_ID");
				rental.setAccount(DBReader.getAccountQuery(accountID));
				copyID = myRs.getInt("copy_ID");
				rental.setMediaCopy(DBReader.getMediaCopyQuery(copyID));
				
				//For Testing.  Comment out later.
				/*System.out.println(rental.getRentalID() + ", " + rental.getDateRented() + ", " + rental.getDateDue() + 
						", " + rental.isActive() + ", " + rental.getAccount().getAccountID() + ", " + rental.getMediaCopy().getMediaCopyId());*/
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
		}
		return rental;

	}
	
	/**
	 * Retrieves a reservation from the database
	 * @param reservation_ID the reservation's ID number
	 * @return the Reservation object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the reservation id
	 * @postcondition a reservation object with either the reservation information for a found reservation or with null values.
	 */
	public static List<Rental> getAccountRentalsQuery(int accountID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Rental rental = null;
		ArrayList<Rental> rentals = null;
		//int totalRows;
		int row = 0;
		int copyID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			rental = new Rental();
			rentals = new ArrayList<Rental>();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_account_rentals(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, accountID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
						
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				rental.setRentalID(myRs.getInt("rental_ID"));
				rental.setDateRented(myRs.getDate("date_rented"));
				rental.setDateDue(myRs.getDate("date_due"));
				rental.setActive(myRs.getBoolean("active"));
				rental.setAccount(DBReader.getAccountQuery(accountID));
				copyID = myRs.getInt("copy_ID");
				rental.setMediaCopy(DBReader.getMediaCopyQuery(copyID));
				
				rentals.add(rental);
				
				//For Testing.  Comment out later.
				/*System.out.println(rentals.get(row).getRentalID() + ", " + rentals.get(row).getDateRented()+ ", "+ rentals.get(row).getDateDue() + ", " + 
						rentals.get(row).isActive() + ", " + rentals.get(row).getAccount().getAccountID() + ", " + 
						rentals.get(row).getMediaCopy().getMediaCopyId());*/
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
			db.endConnection(myConn); //Closes the connection
		}
		return rentals;
	}
	
	/**
	 * Retrieves a reservation from the database
	 * @param reservation_ID the reservation's ID number
	 * @return the Reservation object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the reservation id
	 * @postcondition a reservation object with either the reservation information for a found reservation or with null values.
	 */
	public static Reservation getReservationQuery(int reservationID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Reservation reservation = new Reservation();
		int accountID;
		int copyID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_reservation_info(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, reservationID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				reservation.setReservationId(myRs.getInt("reservation_ID"));
				reservation.setReservationDate(myRs.getDate("reservation_date"));
				reservation.setReservationActive(myRs.getBoolean("active"));
				accountID = myRs.getInt("account_ID");
				reservation.setCustomerAccount(DBReader.getAccountQuery(accountID));
				copyID = myRs.getInt("copy_ID");
				reservation.setMediaCopy(DBReader.getMediaCopyQuery(copyID));
				
				//For Testing.  Comment out later.
				/*System.out.println(reservation.getReservationId() + ", " + reservation.getReservationDate() + ", " + reservation.isReservationActive() + 
						", " + reservation.getCustomerAccount().getAccountID() + ", " + reservation.getMediaCopy().getMediaCopyId());*/
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection
		}
		return reservation;
	}
	
	/**
	 * Retrieves a reservation from the database
	 * @param reservation_ID the reservation's ID number
	 * @return the Reservation object or NULL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the reservation id
	 * @postcondition a reservation object with either the reservation information for a found reservation or with null values.
	 */
	public static List<Reservation> getAccountReservationsQuery(int accountID) throws FileNotFoundException, IOException, SQLException 
	{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Reservation reservation = null;
		ArrayList<Reservation> reservations = null;
		//int totalRows;
		int row = 0;
		int copyID;
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			reservation = new Reservation();
			reservations = new ArrayList<Reservation>();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_account_reservations(?)}");
			
			//Sets the parameter for the prepared statement.
			myStmt.setInt(1, accountID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
			
			//Gets the total number of rows from the result set
			//totalRows = getNumberOfRows(myRs);
			
			//Creates an array of Reservation with the size of total rows from the result set
			//reservation = new Reservation[totalRows];
			//generateReservations(reservation);
			
			//Loops through the result set and sets all the properties to the corresponding object variables
			while(myRs.next()){
				
				/*reservation[row].setReservationId(myRs.getInt("reservation_ID"));
				reservation[row].setReservationDate(myRs.getDate("reservation_date"));
				reservation[row].setReservationActive(myRs.getBoolean("active"));
				reservation[row].setCustomerAccount(DBReader.getAccountQuery(accountID));
				copyID = myRs.getInt("copy_ID");
				reservation[row].setMediaCopy(DBReader.getMediaCopyQuery(copyID));*/
				
				reservation.setReservationId(myRs.getInt("reservation_ID"));
				reservation.setReservationDate(myRs.getDate("reservation_date"));
				reservation.setReservationActive(myRs.getBoolean("active"));
				reservation.setCustomerAccount(DBReader.getAccountQuery(accountID));
				copyID = myRs.getInt("copy_ID");
				reservation.setMediaCopy(DBReader.getMediaCopyQuery(copyID));
				
				reservations.add(reservation);
				
				//For Testing.  Comment out later.
				/*System.out.println(reservations.get(row).getReservationId() + ", " + reservations.get(row).getReservationDate() + ", " + reservations.get(row).isReservationActive() + 
						", " + reservations.get(row).getCustomerAccount().getAccountID() + ", " + reservations.get(row).getMediaCopy().getMediaCopyId());*/
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
			db.endConnection(myConn); //Closes the connection
		}
		return reservations;
	}
	
	/**
	 * Checks if the given email and password match an account
	 * @param email an email address 
	 * @param password a password
	 * @return True if a match is found, False if no match is found
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an email string and a password string
	 * @postcondition an account object with either the account information for a found account or with null values.
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
				
				//For Testing.  Comment out later.
				/*System.out.println(account.getAccountID() + ", " + account.getFirstName() + ", " + account.getLastName() +
						", " + account.getPhoneNumber() + ", " + account.getEmail());*/
				
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection to the database
		}

		return account;
	}
	
	/**
	 * Retrieves information about a format from the database
	 * @param formatID the format's id
	 * @return the format
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the format id
	 * @postcondition a format object with either the format information for a found format or with null values.
	 */
	public static Format getFormat(int formatID) throws FileNotFoundException, IOException, SQLException{
		
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		Format format = new Format();
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_format_info(?)}");
			
			//Sets the parameter for the prepared statement.  
			myStmt.setInt(1, formatID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
						
			//Loops through the result set and sets all the properties to the corresponding object variables
			while (myRs.next()) {
				
				format.setFormatID(myRs.getInt("format_ID"));
				format.setType(myRs.getString("type"));
				
				//For Testing.  Comment out later.
				//System.out.println(format.getFormatID() + ", " + format.getType());
				
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection to the database
		}

		return format;
	}
	
	/**
	 * Retrieves information about a price tier from the database
	 * @param priceID the price tier's id
	 * @return the price tier object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @precondition an integer greater than 0 for the priceID
	 * @postcondition a price tier object with either the price tier information for a found price tier or with null values.
	 */
	public static PriceTier getPriceTier(int priceID) throws FileNotFoundException, IOException, SQLException{
		DatabaseConnector db = null;
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		PriceTier priceTier = new PriceTier();
		try{
			//Creates a Database object to establish a connection
			db = new DatabaseConnector();
			myConn = db.getConnection();
			
			// Creates a prepared statement query
			myStmt = myConn.prepareCall("{call get_priceTier_info(?)}");
			
			//Sets the parameter for the prepared statement.  
			myStmt.setInt(1, priceID);
			
			//Execute the query to the database
			myRs = myStmt.executeQuery();
						
			//Loops through the result set and sets all the properties to the corresponding object variables
			while (myRs.next()) {
				
				priceTier.setPriceID(myRs.getInt("price_ID"));
				priceTier.setRentalPeriod(myRs.getInt("rental_period"));
				priceTier.setPriceTier(myRs.getString("price_tier"));
				priceTier.setPrice(myRs.getDouble("price"));
				
				
				//For Testing.  Comment out later.
				/*System.out.println(priceTier.getPriceID() + ", " + priceTier.getRentalPeriod() + ", " + priceTier.getPriceTier() + ", " + 
						priceTier.getPrice());*/
				
			}
		}
		finally{
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			db.endConnection(myConn); //Closes the connection to the database
		}

		return priceTier;
	}

}
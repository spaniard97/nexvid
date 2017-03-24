package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;
import com.nexvid.accounts.*;


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
	 */
	public Account getAccountQuery(int account_ID) 
	{
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
	 */
	public MediaCopy[] getMediaCopiesQuery(int media_ID)
	{
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
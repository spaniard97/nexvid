package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;
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
	 * @precondition the media does not already exist
	 * @postcondition a media is added to the database
	 */
	public void addNewMediaQuery(Media media){
		
	}
	
	/**
	 * Adds a media copy to the database
	 * @param mediaCopy a new MediaCopy object
	 * @postcondition a media copy is added to the database
	 */
	public void addMediaCopyQuery(MediaCopy mediaCopy){
		
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
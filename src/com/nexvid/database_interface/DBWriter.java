package com.nexvid.database_interface;

import com.nexvid.inventory_manager.*;
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
	 * @precondition an account matching an account record that exists in the database by account_ID
	 * @postcondition the matching account is modified in the database
	 */
	public void setAccountQuery(Account account){
		
	}
	
	/**
	 * Receives a SubAccount object that already exists in the database, then writes to the database.
	 * This is used to modify the record. 
	 * @param subAccount a subAccount object
	 * @precondition a subAccount matching a subAccount record that exists in the database by sub_ID
	 * @postcondition the matching subAccount is modified in the database 
	 */
	public void setSubAccountQuery(SubAccount subAccount){
		
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
}

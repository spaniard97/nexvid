package com.nexvid.inventory_manager;

import java.util.Date;
import java.util.Calendar;
import com.nexvid.accounts.*;

/**
 * The Rental class is responsible for creating Rental objects.
 * @author Samuel Pimenta, Brian Chan
 * @since 03/19/2017
 * @version 1.0.0.2
 *
 */
public class Rental {
	
	public int rentalID;
	public java.sql.Date dateRented;
	public java.sql.Date dateDue;
	public boolean isActive;
	public Account account;
	public MediaCopy mediaCopy;
	private static final int RENTAL_PERIOD = 7;
	private static final int NEW_RENTAL_PERIOD = 3;
	
	//This class needs to be discussed - JC
	
	/**
	 * The default constructor for the Rental class.
	 */
	public Rental(){
		
	}
	
	/**
	 * The constructor creates a new Rental object.
	 * @param customerAccount The customer account
	 * @param selectedMedia The media selected by the customer
	 * @param id The rental id
	 * @param dayRented Day the media was rented
	 * @param active True if rental is still active
	 */
	public Rental(Account customerAccount, MediaCopy selectedMedia, int id, Calendar dayRented, boolean active)
	{
		//Need a new rental for new items
		Calendar temp = dayRented;
		this.account = customerAccount;
		this.mediaCopy = selectedMedia;
		this.rentalID = id;
		Date myDate = temp.getTime();
		this.dateRented = new java.sql.Date(myDate.getTime());
		temp.add(Calendar.DAY_OF_MONTH, RENTAL_PERIOD);
		myDate = temp.getTime();
		this.dateDue = new java.sql.Date(myDate.getTime());
		this.isActive = active;
	}

	/**
	 * Get a customer's account object.
	 * @return The customer's account object
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * Set a customer's account object.
	 * @param account The customer's account object
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * Get a Media class object.
	 * @return The media object
	 */
	public MediaCopy getMediaCopy() {
		return mediaCopy;
	}

	/**
	 * Set a Media class object.
	 * @param media The media object
	 */
	public void setMediaCopy(MediaCopy mediaCopy) {
		this.mediaCopy = mediaCopy;
	}
	
	/**
	 * Get a rental's Id number.
	 * @return The rental Id number
	 */
	public int getRentalID() {
		return rentalID;
	}

	/**
	 * Set a rental's Id number.
	 * @param rentalID The rental's Id number
	 */
	public void setRentalID(int rentalID) {
		this.rentalID = rentalID;
	}

	/**
	 * Get the date a media is rented.
	 * @return The date the media is rented
	 */
	public java.sql.Date getDateRented() {
		return dateRented;
	}

	/**
	 * Set the date a media is rented.
	 * @param dateRented The date the media is rented
	 */
	public void setDateRented(Date dateRented) {
		this.dateRented = new java.sql.Date(dateRented.getTime());
	}

	/**
	 * Get the date a media is due.
	 * @return The date the media is due
	 */
	public java.sql.Date getDateDue() {
		return dateDue;
	}

	/**
	 * Set the date a media is due.
	 * @param dateDue The date the media is due
	 */
	public void setDateDue(Date dateDue)
	{
		this.dateDue = new java.sql.Date(dateDue.getTime());
	}

	/**
	 * Checks if the media is active.
	 * @return True if the media is active
	 * @return False if the media is active
	 */
	public boolean isActive()
	{
		return isActive;
	}

	/**
	 * Set a media to active or inactive.
	 * @param isActive True if the media is active
	 */
	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

}

package com.nexvid.inventory_manager;

import java.util.Date;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import com.nexvid.accounts.*;
import com.nexvid.database_interface.DBReader;

/**
 * The Rental class is responsible for creating Rental objects.
 * @author Samuel Pimenta, Brian Chan, Juan Carlos Pinillos
 * @since 03/19/2017
 * @version 1.0.0.2
 *
 */
public class Rental {
	
	protected int rentalID;
	protected java.sql.Date dateRented;
	protected java.sql.Date dateDue;
	protected boolean isActive;
	protected Account account;
	protected MediaCopy mediaCopy;
	private static final int RENTAL_PERIOD = 7;
	private static final int NEW_RENTAL_PERIOD = 3;
	
	
	/**
	 * The default constructor for the Rental class.
	 */
	public Rental()
	{
		
	}
	
	public Rental(Account account, MediaCopy mediaCopy, java.sql.Date dateRented,
			java.sql.Date dueDate){
		this.account = account;
		this.mediaCopy = mediaCopy;
		this.dateRented = dateRented;//sqlToday();
		this.dateDue = dueDate;// generateDueDate(mediaCopy, Calendar.getInstance());
		this.isActive = true;
		
		
	}
	
	/**
	 * The constructor creates a new Rental object.
	 * @param customerAccount The customer account
	 * @param selectedMedia The media selected by the customer
	 * @param id The rental id
	 * @param dayRented Day the media was rented
	 * @param active True if rental is still active
	 * @param isNew True if the rented media is a new release
	 */
	public Rental(Account customerAccount, MediaCopy selectedMedia, int id, Calendar dayRented, boolean active, boolean isNew)
	{
		if(isNew)
		{
			Calendar cal = dayRented;
			this.account = customerAccount;
			this.mediaCopy = selectedMedia;
			this.rentalID = id;
			Date myDate = cal.getTime();
			this.dateRented = new java.sql.Date(myDate.getTime());
			cal.add(Calendar.DAY_OF_MONTH, NEW_RENTAL_PERIOD);
			myDate = cal.getTime();
			this.dateDue = new java.sql.Date(myDate.getTime());
			this.isActive = active;
		}
		else
		{
			Calendar cal = dayRented;
			this.account = customerAccount;
			this.mediaCopy = selectedMedia;
			this.rentalID = id;
			Date myDate = cal.getTime();
			this.dateRented = new java.sql.Date(myDate.getTime());
			cal.add(Calendar.DAY_OF_MONTH, RENTAL_PERIOD);
			myDate = cal.getTime();
			this.dateDue = new java.sql.Date(myDate.getTime());
			this.isActive = active;
		}
		
	}

	/**
	 * Get a customer's account object.
	 * @return The customer's account object
	 */
	public Account getAccount() {
		return this.account;
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
		return this.mediaCopy;
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
		return this.rentalID;
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
		return this.dateRented;
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
		return this.dateDue;
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
		
	public String rentalToJSONString(){
		
		String _JSON =  "{\"rentalID\":\"" + this.rentalID + "\"," +
    			"\"dateRented\":\"" + this.dateRented + "\"," + 
    			"\"dateDue\":\"" + this.dateDue + "\"," + 
    			"\"isActive\":\"" + this.isActive + "\"," +
    			"\"account\":" + this.account.AccountToJSONString() + "," +
    			"\"mediaCopy\":" + this.mediaCopy.mediaCopyToJSONString() +
    			"}";
		
    	return _JSON;
	}

}
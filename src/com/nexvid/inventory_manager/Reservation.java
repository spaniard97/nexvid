package com.nexvid.inventory_manager;

import java.util.Calendar;
import java.util.Date;
import com.nexvid.accounts.*;

/**
 * The Reservation class is responsible for creating reservation objects.
 * @author Samuel Pimenta, Juan Carlos Pinillos
 * @since 03/20/2013
 * @version 1.0.0.0
 *
 */
public class Reservation {
	
	protected int reservationId;
	protected java.sql.Date reservationDate;
	protected boolean isReservationActive;
	protected Account customerAccount;
	protected MediaCopy mediaCopy;
	
	/**
	 * Default constructor
	 */
	public Reservation(){
		
	}
	
	/**
	 * Creates a reservation object.
	 * @param id the reservation Id
	 * @param dateReserved The date the media was reserved
	 * @param isActive True if reservation is active
	 * @param account The customer account for the account number
	 * @param mediaCopy The media copy to be reserved
	 */
	public Reservation(int id, Calendar dateReserved, boolean isActive, Account account,
			MediaCopy mediaCopy){
		this.reservationId = id;
		Date myDate = dateReserved.getTime();
		this.reservationDate = new java.sql.Date(myDate.getTime());
		this.isReservationActive = isActive;
		this.customerAccount = account;
		this.mediaCopy = mediaCopy;
	}

	/**
	 * Get a reservation's Id number.
	 * @return The reservation's Id number
	 */
	public int getReservationId() {
		return this.reservationId;
	}

	/**
	 * Set a reservation's Id number.
	 * @param reservationId The reservation's Id number
	 */
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * Get a reservation's date.
	 * @return The reservation's date
	 */
	public java.sql.Date getReservationDate() {
		return this.reservationDate;
	}

	/**
	 * Set a reservation's date.
	 * @param reservationDate The reservation's date
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = new java.sql.Date(reservationDate.getTime());
	}

	/**
	 * Check if reservation is active
	 * @return True if reservation is active
	 * @return False if the reservation is inactive
	 */
	public boolean isReservationActive() {
		return this.isReservationActive;
	}

	/**
	 * Set the reservation's status.
	 * @param isReservationActive The reservation's status
	 */
	public void setReservationActive(boolean isReservationActive) {
		this.isReservationActive = isReservationActive;
	}

	/**
	 * Get a customer's account object.
	 * @return The customer's account object
	 */
	public Account getCustomerAccount() {
		return this.customerAccount;
	}

	/**
	 * Set a customer's account object.
	 * @param customerAccount The customer's account object
	 */
	public void setCustomerAccount(Account customerAccount) {
		this.customerAccount = customerAccount;
	}

	/**
	 * Get a media copy object.
	 * @return The media copy object
	 */
	public MediaCopy getMediaCopy() {
		return this.mediaCopy;
	}

	/**
	 * Set a media copy object.
	 * @param mediaCopy The media object
	 */
	public void setMediaCopy(MediaCopy mediaCopy) {
		this.mediaCopy = mediaCopy;
	}
	
public String reservationToJSONString(){
		
		String _JSON =  "{\"reservationId\":\"" + this.reservationId + "\"," +
    			"\"reservationDate\":\"" + this.reservationDate + "\"," + 
    			"\"isReservationActive\":\"" + this.isReservationActive + "\"," +
    			"\"account\":" + this.customerAccount.AccountToJSONString() + "," +
    			"\"mediaCopy\":" + this.mediaCopy.mediaCopyToJSONString() +
    			"}";
		
    	return _JSON;
	}
	
}

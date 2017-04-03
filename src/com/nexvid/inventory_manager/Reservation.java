package com.nexvid.inventory_manager;

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
	protected Date reservationDate;
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
	public Reservation(int id, Date dateReserved, boolean isActive, Account account,
			MediaCopy mediaCopy){
	}

	/**
	 * Get a reservation's Id number.
	 * @return The reservation's Id number
	 */
	public int getReservationId() {
		return reservationId;
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
	public Date getReservationDate() {
		return reservationDate;
	}

	/**
	 * Set a reservation's date.
	 * @param reservationDate The reservation's date
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * Check if reservation is active
	 * @return True if reservation is active
	 * @return False if the reservation is inactive
	 */
	public boolean isReservationActive() {
		return isReservationActive;
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
		return customerAccount;
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
	
}

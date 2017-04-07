package com.nexvid.inventory_manager;

import java.util.Calendar;

import com.nexvid.accounts.*;

/**
 * The Renter class is responsible for rent and return operations.
 * @author Samuel Pimenta, Brian Chan
 * @since 03/19/2017
 * @version 1.0.0.2
 *
 */
public class Renter {
	
	private static Calendar today;
	
	/**
	 * This method allows a customer to rent a specific media.
	 * @param customerAccount the customer account
	 * @param mediaRented the media to be rented
	 * @return a new Rental transaction
	 * @precondition the media and customer account must exist
	 * @postcondition a Rental object is returned
	 */
	public static Rental rentMedia(Account customerAccount, MediaCopy mediaRented)
	{
		Rental temp = new Rental(customerAccount, mediaRented, 0, Calendar.getInstance(), true);
		return temp;
	}
	
	/**
	 * This method allows a customer to return a rented media.
	 * @param customerAccount the customer account
	 * @param mediaReturned the media to be returned
	 * @return a closed Rental transaction
	 * @precondition the media must be rented by the customer
	 * @postcondition  a Rental object is returned
	 */
	public static Rental returnMedia(Account customerAccount, MediaCopy mediaReturned)
	{
		Rental returning = new Rental(customerAccount, mediaReturned, 0, today, false);
		return returning;
	}
}
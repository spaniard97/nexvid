package com.nexvid.inventory_manager;

import com.nexvid.accounts.*;

/**
 * The Renter class is responsible for rent and return operations.
 * @author Samuel Pimenta
 * @since 03/19/2017
 * @version 1.0.0.0
 *
 */
public class Renter {
	
	/**
	 * This method allows a customer to rent a specific media.
	 * @param customerAccount the customer account
	 * @param mediaRented the media to be rented
	 * @return a new Rental transaction
	 * @precondition the media and customer account must exist
	 * @postcondition a Rental object is returned
	 */
	public Rental rentMedia(Account customerAccount, Media mediaRented){
		return null;
	}
	
	/**
	 * This method allows a customer to return a rented media.
	 * @param customerAccount the customer account
	 * @param mediaReturned the media to be returned
	 * @return a closed Rental transaction
	 * @precondition the media must be rented by the customer
	 * @postcondition  a Rental object is returned
	 */
	public Rental returnMedia(Account customerAccount, Media mediaReturned){
		return null;
	}

}

package com.nexvid.inventory_manager;

import com.nexvid.accounts.*;

/**
 * The Reserver class is responsible for reserving operations.
 * @author Samuel Pimenta
 * @since 03/19/2017
 * @version 1.0.0.0
 *
 */
public class Reserver {
	
	/**
	 * This method allows a customer to reserve a specific media.
	 * @param customerAccount the customer account
	 * @param mediaRented the media to be reserved
	 * @return true if the reservation is successful
	 * @return false if the reservation fail
	 * @precondition the media and customer account must exist
	 * @postcondition returns true or false depending on the success of the reserve operation
	 */
	public boolean reserveMedia(Account customerAccount, Media mediaToBeReserved){
		return false;
	}
	
	/**
	 * Cancels a reservation made by a customer.
	 * @param customerAccount the customer account that made the reservation
	 * @param mediaReserved the reserved media
	 * @return true if the reserve cancellation is successful
	 * @return false if the reserve cancellation fail
	 * @precondition the media must be reserved by the account
	 * @postcondition returns true or false depending on the success of the cancellation
	 */
	public boolean cancelReservation(Account customerAccount, Media mediaReserved){
		return false;
	}
}

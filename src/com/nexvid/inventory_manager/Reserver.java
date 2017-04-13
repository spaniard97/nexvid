package com.nexvid.inventory_manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import com.nexvid.accounts.*;
import com.nexvid.database_interface.DBReader;
import com.nexvid.database_interface.DBWriter;

/**
 * The Reserver class is responsible for reserving operations.
 * @author Samuel Pimenta, Brian Chan
 * @since 03/19/2017
 * @version 1.0.1.2
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
	public static Reservation reserveMedia(Account customerAccount, MediaCopy mediaToBeReserved){
		Reservation temp = new Reservation(0, Calendar.getInstance(), mediaToBeReserved.isActive, customerAccount, mediaToBeReserved);
		temp.setReservationActive(true);
		mediaToBeReserved.setReserved(true);		
		try
		{
			DBWriter.setReservation(temp);
			return temp;
		}
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not make reservation.");
		}
		return null;
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
	public boolean cancelReservation(Account customerAccount, MediaCopy mediaReserved){
		Reservation temp = new Reservation(0, Calendar.getInstance(), mediaReserved.isActive, customerAccount, mediaReserved);
		temp.setReservationActive(false);
		mediaReserved.setReserved(false);
		try
		{
			DBWriter.changeReserveStatus(mediaReserved);
			return true;
		}
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not cancel reservation");
		}
		return false;
	}
}

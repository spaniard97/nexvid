package com.nexvid.inventory_manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.jws.WebService;
import javax.jws.WebMethod;

import com.nexvid.accounts.*;
import com.nexvid.database_interface.DBAdder;
import com.nexvid.database_interface.DBReader;
import com.nexvid.database_interface.DBWriter;

/**
 * The Reserver class is responsible for reserving operations.
 * @author Samuel Pimenta, Brian Chan
 * @since 03/19/2017
 * @version 1.0.1.2
 *
 */
@WebService (serviceName="Reserver")
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
	public int reserveMedia(int customerAccount, int mediaToBeReserved){
		
		Account account = null;
		MediaCopy mediaCopy = null;
		Reservation newReservation = new Reservation();
		int reservationID = 0;
				
		try
		{
			account = DBReader.getAccountQuery(customerAccount);
			mediaCopy = DBReader.getMediaCopyQuery(mediaToBeReserved);
			if(canBeReserved(mediaCopy)){
				newReservation.setReservationDate(sqlToday());
				newReservation.setReservationActive(true);
				newReservation.setCustomerAccount(account);
				newReservation.setMediaCopy(mediaCopy);
				reservationID = DBAdder.addNewReservationQuery(newReservation);
				mediaCopy.setReserved(true);
				DBWriter.changeReserveStatus(mediaCopy);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return reservationID;
	}
	
	/**
	 * Cancels a reservation made by a customer.
	 * @param mediaCopyID the copy id of the reserved media
	 * @return true if the reserve cancellation is successful
	 * @return false if the reserve cancellation fail
	 * @precondition the media must be reserved by the account
	 * @postcondition returns true or false depending on the success of the cancellation
	 */
	public boolean cancelReservation(int mediaCopyID){

		Reservation reservation = null;
		MediaCopy mediaCopy = null;
		
		try {
			mediaCopy = DBReader.getMediaCopyQuery(mediaCopyID);
			reservation = DBReader.getReservationByCopyIDQuery(mediaCopyID);
			System.out.println("Is the media reserved?: " + mediaCopy.isReserved());
			System.out.println("Is the reservation active?: " + reservation.isReservationActive());
			mediaCopy.setReserved(false);
			DBWriter.changeReserveStatus(mediaCopy);
			reservation.setReservationActive(false);
			DBWriter.deactivate(reservation);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(!reservation.isReservationActive()){
			System.out.println("Is the media reserved?: " + mediaCopy.isReserved());
			System.out.println("Is the reservation active?: " + reservation.isReservationActive());
			return true;
		}
		System.out.println("Is the media reserved?: " + mediaCopy.isReserved());
		System.out.println("Is the reservation active?: " + reservation.isReservationActive());
		return false;
	}
	
	/**
	 * Gets today's date as a java.sql.Date type
	 * @return the current date
	 */
	public java.sql.Date sqlToday(){
		java.sql.Date today = null;
		Calendar cal = Calendar.getInstance();
		Date myDate = cal.getTime();
		today = new java.sql.Date(myDate.getTime());
		return today;
	}
	
	/**
	 * Checks if the media copy can be rented
	 * @param account the account object which wants to rent the media copy
	 * @param mediaCopy the media copy to check if it can be rented
	 * @return true if the media copy can be rented, false otherwise.
	 */
	public boolean canBeReserved(MediaCopy mediaCopy){
		
		if(mediaCopy.isActive() && !mediaCopy.isRented() && !mediaCopy.isReserved()){
			return true;
		}
		return false;
	}

}


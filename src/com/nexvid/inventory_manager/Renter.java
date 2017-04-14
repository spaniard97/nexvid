package com.nexvid.inventory_manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import com.nexvid.accounts.*;
import com.nexvid.database_interface.DBReader;
import com.nexvid.database_interface.DBWriter;

/**
 * The Renter class is responsible for rent and return operations.
 * @author Samuel Pimenta, Brian Chan, Juan Carlos Pinillos
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
		today = Calendar.getInstance();
		Rental temp = new Rental(customerAccount, mediaRented, 0, today, mediaRented.isActive(), mediaRented.getAcquiredStatus());
		mediaRented.setRented(true);
		try
		{
			DBWriter.setRentalQuery(temp);
			DBWriter.changeRentStatus(mediaRented);
			return temp;
		} catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not make a rental.");
		}
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
	public static Rental returnMedia(Account customerAccount, MediaCopy mediaReturned)
	{
		today = Calendar.getInstance();
		Rental temp = new Rental(customerAccount, mediaReturned, 0, today, mediaReturned.isActive(), mediaReturned.getAcquiredStatus());
		if(Calendar.getInstance().after(temp.getDateDue()))
		{
			customerAccount.setBalanceOwed(customerAccount.getBalanceOwed() + 2.00); 
		}
		mediaReturned.setRented(false);
		try
		{
			DBWriter.setRentalQuery(temp);
			DBWriter.changeRentStatus(mediaReturned);
		} 
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not return item.");
		}
		return null;
	}
}
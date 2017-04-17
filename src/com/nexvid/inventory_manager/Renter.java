package com.nexvid.inventory_manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.nexvid.accounts.*;
import com.nexvid.database_interface.DBAdder;
import com.nexvid.database_interface.DBReader;
import com.nexvid.database_interface.DBWriter;

/**
 * The Renter class is responsible for rent and return operations.
 * @author Samuel Pimenta, Brian Chan, Juan Carlos Pinillos
 * @since 03/19/2017
 * @version 1.0.0.2
 *
 */
@WebService(serviceName="Renter")
public class Renter {
	
	//private static Calendar today;
	private static final double LATE_FEE = 2.00;
	
	/**
	 * This method allows a customer to rent a specific media.
	 * @param customerAccount the customer account
	 * @param mediaRented the media to be rented
	 * @return a new Rental transaction
	 * @precondition the media and customer account must exist
	 * @postcondition a Rental object is returned
	 */
	@WebMethod(operationName="rentMedia")
	public int rentMedia(int customerAccountID, int mediaRentedID)
	{
		//today = Calendar.getInstance();
		
		Account account = null;
		MediaCopy mediaCopy = null;
		Rental newRental = null;
		int rentalID = 0;
		//int priceID = 0;
		
		try
		{
			account = DBReader.getAccountQuery(customerAccountID);
			mediaCopy = DBReader.getMediaCopyQuery(mediaRentedID);
			if(canBeRented(account, mediaCopy)){
				java.sql.Date today = sqlToday();
				java.sql.Date dueDate = generateDueDate(mediaCopy, Calendar.getInstance());
				newRental = new Rental(account, mediaCopy, today, dueDate);
				rentalID = DBAdder.addNewRentalQuery(newRental);
				mediaCopy.setRented(true);
				DBWriter.changeRentStatus(mediaCopy);
				System.out.println(rentalID);
			}
			else{
				rentalID = 0;
				System.out.println(rentalID);
			}
			
			
			//DBWriter.setRentalQuery(newRental);
			//DBWriter.changeRentStatus(mediaRented);

		} catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not make a rental.");
		}
		
		return rentalID;
	}
	
	/**
	 * This method allows a customer to return a rented media.
	 * @param customerAccount the customer account
	 * @param mediaReturned the media to be returned
	 * @return a closed Rental transaction
	 * @precondition the media must be rented by the customer
	 * @postcondition a double for the added fine is returned
	 */
	public double returnMedia(int mediaReturnedID)
	{
		Account account = null;
		MediaCopy mediaCopy = null;
		Rental rental = null;
		double fine = 0.00;

		try
		{
			rental = DBReader.getRentalByCopyIDQuery(mediaReturnedID);
			account = DBReader.getAccountQuery(rental.getAccount().getAccountID());
			mediaCopy = DBReader.getMediaCopyQuery(mediaReturnedID);
			
			if(isLate(rental)){
				fine = account.getBalanceOwed() + calculateFine(rental);
				System.out.println(fine);
				account.setBalanceOwed(fine);
				DBWriter.setAccountBalance(account);
			}		
			
			//DBWriter.setRentalQuery(newRental);
			mediaCopy.setRented(false);
			DBWriter.changeRentStatus(mediaCopy);
			DBWriter.deactivate(rental);

		} catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not make a rental.");
		}
		
		return fine;
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
	 * Generates the due date of a rental based on the media copy as a sql date
	 * @param mediaCopy the media copy object
	 * @param cal an instance of a Calendar.  For example, Calendar.getInstance()
	 * @return the media copies due date
	 */
	public java.sql.Date generateDueDate(MediaCopy mediaCopy, Calendar cal){
		
		java.sql.Date dueDate = null;
		Date date = null;
		PriceTier price = null;
		Media media = null;
		try {
			media = DBReader.getMediaByMediaIDQuery(mediaCopy.getMediaId());
			price = DBReader.getPriceTier(media.getPrice().getPriceID());
			cal.add(Calendar.DAY_OF_MONTH, price.getRentalPeriod());
			date = cal.getTime();
			dueDate = new java.sql.Date(date.getTime());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dueDate;
	}
	
	/**
	 * Checks if the media copy can be rented
	 * @param account the account object which wants to rent the media copy
	 * @param mediaCopy the media copy to check if it can be rented
	 * @return true if the media copy can be rented, false otherwise.
	 */
	public boolean canBeRented(Account account, MediaCopy mediaCopy){
		Reserver reserver = new Reserver();
		try {
			if(mediaCopy.isActive() && !mediaCopy.isRented()){
				System.out.println("first if.");
				if(mediaCopy.isReserved()){
					Reservation reserve = DBReader.getReservationByCopyIDQuery(mediaCopy.getMediaCopyId());
					System.out.println("second if.");
					System.out.println(account.getAccountID() + ", " + reserve.getCustomerAccount().getAccountID());
					if(account.getAccountID() == reserve.getCustomerAccount().getAccountID()){
						reserver.cancelReservation(mediaCopy.getMediaCopyId());
						System.out.println("third if.");
						return true;
					}
				}
				else{
					System.out.println("else.");
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Nothing.");
		return false;
	}
	
	/**
	 * Calculates the number of days between the current date and the due date
	 * Can be used to determine if a return is late and how late
	 * @param rental the rental object to check
	 * @return the number of days
	 */
	public int calculateDays(Rental rental){
		int daysLate = 0;
		java.sql.Date today = sqlToday();//new java.sql.Date(tempDate1.getTime());
		java.sql.Date dueDate = rental.getDateDue();//new java.sql.Date(tempDate2.getTime());
		
		Date dateToday = today.valueOf(today.toString());
		Date dateDueDate = dueDate.valueOf(dueDate.toString());
		
		System.out.println(dateToday);
		System.out.println(dateDueDate);
		
		long testValue = getDateDiff(dateDueDate, dateToday, TimeUnit.DAYS);
		System.out.println("The difference in time is "+ testValue + " days");
		
		daysLate = (int) testValue;
		
		return daysLate;
	}
	
	/**
	 * Calculates the fine for a late rental return
	 * @param rental the rental that was returned
	 * @return the fine to be added to the customer's balance
	 */
	public double calculateFine(Rental rental){
		double fine = 0.00;
		fine = (double) calculateDays(rental) * LATE_FEE;
		return fine;
	}
	
	/**
	 * Checks if a return is late
	 * @param rental the rental to check
	 * @return true if the current day is passed the due date
	 */
	public boolean isLate(Rental rental){
		
		if(calculateDays(rental) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the difference in days of two dates
	 * @param dueDate the rentals due date
	 * @param today the current date
	 * @param time a TimeUnit value.  For example TimeUnit.DAYS
	 * @return the number of days between the two dates.
	 */
	public static long getDateDiff(Date dueDate, Date today, TimeUnit time)
	{
		long diffInTime = dueDate.getTime() - today.getTime();
		return time.convert(diffInTime, TimeUnit.MILLISECONDS);
	}

}
package com.nexvid.database_interface;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.nexvid.accounts.*;
import com.nexvid.inventory_manager.*;

public class DatabaseTester {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		try {
						
			Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-22");
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			
			//Gets current date
			Date myDate2 = new Date();
			java.sql.Date today = new java.sql.Date(myDate2.getTime());
			//System.out.println(today);
			
			//Gets current date plus 2 days
			Calendar myCal = Calendar.getInstance();
			myCal.add(Calendar.DATE, 2);
			myDate2 = myCal.getTime();
			java.sql.Date dateDue = new java.sql.Date(myDate2.getTime());
			//System.out.println(dateDue);
			
			Account myAccount = DBReader.getAccountQuery(100000019);
			SubAccount mySub = new SubAccount(0, sqlDate, "Tiffany", "Smith", true, myAccount);
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			Media myMedia = new Media(0, "The Matrix 2", 0, 7, "Movie", mediaPrice, mediaFormat);
			MediaCopy myCopy = new MediaCopy(6, "The Matrix 2", 0, 0, "Movie", mediaPrice, mediaFormat, 4, false, false, "New", true);
			Rental rental = new Rental(myAccount, myCopy, 4, Calendar.getInstance(), true, true);
			Reservation reserve = new Reservation(0, Calendar.getInstance(), true, myAccount, myCopy);
			//Rental rental = Renter.rentMedia(myAccount, myCopy);
			//Reservation reserve = Reserver.reserveMedia(myAccount, myCopy);

			
			/******************************************************************************
			 * Reader Queries
			 ******************************************************************************/
			/*System.out.println("Account Query:");
			DBReader.getAccountQuery(100000004);*/
			
			/*System.out.println("\nSubAccount Query:");
			DBReader.getSubAccountQuery(2);*/
			
			/*System.out.println("\nMedia Query:");
			DBReader.getMediaQuery(2);
			
			System.out.println("\nMediaCopies Query:");
			DBReader.getMediaCopiesQuery(1);
			
			System.out.println("\nMediaCopy Query:");
			DBReader.getMediaCopyQuery(4);
			
			System.out.println("\nloginQuery:");
			DBReader.loginQuery("allender@hotmail.com", "alender1");
			
			System.out.println("\nRental Query:");
			DBReader.getRentalQuery(1);
			
			System.out.println("\nReservation Query:");
			DBReader.getReservationQuery(1);
			
			System.out.println("\nFormat Query:");
			DBReader.getFormat(2);
			
			System.out.println("\nPriceTier Query:");
			DBReader.getPriceTier(3);*/
			
			/*System.out.println("\ngetAccountReservations Query: ");
			DBReader.getAccountReservationsQuery(myAccount.getAccountID());*/
			
			/*System.out.println("\ngetAccountRentals Query: ");
			DBReader.getAccountRentalsQuery(myAccount.getAccountID());*/
			
			/*AccountManager aManager = new AccountManager();
			aManager.getAccountReservations(myAccount);*/
			
			/*****************************************************************************
			 * Adder Queries
			 *****************************************************************************/
			//Uncomment to execute.  But change Media object as to not duplicate values
			//System.out.println("\naddNewMedia Query:");
			//PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			//Format mediaFormat = new Format(1, "Blu-ray");
			/*int mediaID = DBAdder.addNewMediaQuery(myMedia);
			System.out.println("The returned ID is: " + mediaID);*/

			/*System.out.println("\naddMediaCopy Query:");
			int copyID = DBAdder.addMediaCopyQuery(myCopy);
			System.out.println("The returned ID is: " + copyID);*/
			
			System.out.println("\naddNewFormat Query:");
			Format myFormat = new Format(0, "Beta");
			int formatID = DBAdder.addNewFormatQuery(myFormat);
			System.out.println("The returned ID is: " + formatID);
			
			/*System.out.println("\naddNewPriceTier Query:");
			double thePrice = 3.99;
			PriceTier myPrice = new PriceTier(0, 10, "Classics", thePrice);
			DBAdder.addNewPriceTier(myPrice);*/
			
			/*System.out.println("\naddNewAccount Query:");
			Account myAccount2 = new Account(0, "Sam", "Works", "6042259587", "SamWorks7@hotmail.com", "BC", "North Vancouver", "V5J8U7", 
					"Canada", "Definitely Rd", 0, 12, "Registered Customer", "Active", 0, "brazil", "cheap");
			DBAdder.addNewAccountQuery(myAccount2);*/
			
			System.out.println("\naddNewSubAccount Query:");
			int subID = DBAdder.addNewSubAccountQuery(mySub);
			System.out.println("The returned ID is: " + subID);
			
			System.out.println("\naddNewRental Query:");
			int rentalID = DBAdder.addNewRentalQuery(rental);
			System.out.println("The returned ID is: " + rentalID);
			/*myCopy.setMediaCopyId(8);
			rental.setMediaCopy(myCopy);
			DBAdder.addNewRentalQuery(rental);
			myCopy.setMediaCopyId(6);
			rental.setMediaCopy(myCopy);
			DBAdder.addNewRentalQuery(rental);
			myCopy.setMediaCopyId(1);
			rental.setMediaCopy(myCopy);
			DBAdder.addNewRentalQuery(rental);*/
			
			System.out.println("\naddNewReserve Query:");
			int reservationID = DBAdder.addNewReservationQuery(reserve);
			System.out.println("The returned ID is: " + reservationID);
			/*myCopy.setMediaCopyId(8);
			reserve.setMediaCopy(myCopy);
			DBAdder.addNewReservationQuery(reserve);
			myCopy.setMediaCopyId(6);
			reserve.setMediaCopy(myCopy);
			DBAdder.addNewReservationQuery(reserve);
			myCopy.setMediaCopyId(1);
			reserve.setMediaCopy(myCopy);
			DBAdder.addNewReservationQuery(reserve);
			myCopy.setMediaCopyId(2);
			reserve.setMediaCopy(myCopy);
			DBAdder.addNewReservationQuery(reserve);*/

			
			/*****************************************************************************
			 * Writer Queries
			 *****************************************************************************/			
			/*
			System.out.println("\nsetAccount Query:");
			myAccount.setFirstName("Jeff");
			myAccount.setLastName("Johnson");
			myAccount.setPhoneNumber("6047778585");
			myAccount.setEmail("jeff@hotmail.com");
			myAccount.setApartmentNumber(12);
			myAccount.setPassPhrase("my phrases");
			DBWriter.setAccountQuery(myAccount);*/
			
			/*System.out.println("\nsetMedia Query:");
			Media myMedia2 = new Media(2, "The Godfather Part 2", 0, 2, "Movie", mediaPrice, mediaFormat);
			myMedia2.setTitle("The Godfather 2");
			DBWriter.setMediaQuery(myMedia2);*/
			
			/*System.out.println("\nsetSubAccount Query: ");
			mySub.setSubAccountID(8);
			mySub.setFirstName("Jennifer");
			mySub.setActive(false);
			mySub.setDateOfBirth(sqlDate);
			DBWriter.setSubAccountQuery(mySub);*/
			
			/*System.out.println("\nsetMediaCopy");
			myCopy.setMediaCopyId(8);
			myCopy.setRented(true);
			myCopy.setReserved(true);
			myCopy.setState("Good");
			DBWriter.setMediaCopyQuery(myCopy);*/
			
			/*System.out.println("\nsetPriceTier Query: ");
			mediaPrice.setPrice(5);
			mediaPrice.setRentalPeriod(3);
			DBWriter.setPriceTierQuery(mediaPrice);*/
			
			/*System.out.println("\nsetFormat Query: ");
			mediaFormat.setFormatID(3);
			mediaFormat.setType("VHS-HD");
			DBWriter.setFormatQuery(mediaFormat);*/
			
			/*System.out.println("\nsetRental Query: ");
			rental.setDateRented(today);
			rental.setDateDue(dateDue);
			rental.setActive(false);
			rental.setRentalID(4);
			DBWriter.setRentalQuery(rental);*/
			
			/*System.out.println("\nsetReservation Query: ");
			reserve.setReservationId(2);
			reserve.setReservationDate(today);
			reserve.setReservationActive(false);
			DBWriter.setReservation(reserve);*/
			
			/*System.out.println("\ndeactivate Rental Query: ");
			rental.setRentalID(1);
			DBWriter.deactivate(rental);*/
			
			/*System.out.println("\ndeactivate Reservation Query: ");
			reserve.setReservationId(1);
			DBWriter.deactivate(reserve);*/
			
			/*System.out.println("\nchangeStatus Account Query: ");
			Account myAccount2 = new Account();
			myAccount2.setAccountID(100000004);
			myAccount2.setStatus("Suspend");
			DBWriter.changeStatus(myAccount2);*/
					
			/*myCopy.setMediaCopyId(7);
			myCopy.setRented(false);
			myCopy.setReserved(false);
			myCopy.setState("Fair");
			myCopy.setActive(false);
			System.out.println("\nchangeState Media Copy Query: ");
			DBWriter.changeState(myCopy);
			System.out.println("\ndeactivate Media Copy Query: ");
			DBWriter.deactivate(myCopy);
			System.out.println("\nchangeRentStatus Media Copy Query: ");
			DBWriter.changeRentStatus(myCopy);
			System.out.println("\nchangeReserveStatus Media Copy Query: ");
			DBWriter.changeReserveStatus(myCopy);*/
			
			/*System.out.println("\ndeactivate Sub Account Query: ");
			mySub.setSubAccountID(7);
			DBWriter.deactivate(mySub);*/

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
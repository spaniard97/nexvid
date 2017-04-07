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
			
			Account myAccount = DBReader.getAccountQuery(100000019);
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			
			MediaCopy myCopy = new MediaCopy(4, "John Wick", 0, 4, "Movie", mediaPrice, mediaFormat, 4, false, false, "New", true);
			
			Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-22");
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			
			//Gets current date
			Date myDate2 = new Date();
			java.sql.Date today = new java.sql.Date(myDate2.getTime());
			System.out.println(today);
			
			//Gets current date plus 2 days
			Calendar myCal = Calendar.getInstance();
			myCal.add(Calendar.DATE, 2);
			myDate2 = myCal.getTime();
			java.sql.Date dateDue = new java.sql.Date(myDate2.getTime());
			System.out.println(dateDue);
			
			
			/*System.out.println("Account Query:");
			DBReader.getAccountQuery(100000004);
			
			System.out.println("\nSubAccount Query:");
			DBReader.getSubAccountQuery(2);
			
			System.out.println("\nMedia Query:");
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
			
			
			/*Uncomment to execute.  But change Media object as to not duplicate values
			System.out.println("\naddNewMedia Query:");
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			Media myMedia = new Media(0, "John Wick", 0, 4, "Movie", mediaPrice, mediaFormat);
			DBAdder.addNewMediaQuery(myMedia);
			

			System.out.println("\naddMediaCopy Query:");
			DBAdder.addMediaCopyQuery(myCopy);
			
			System.out.println("\naddNewFormat Query:");
			Format myFormat = new Format(0, "VHS");
			DBAdder.addNewFormatQuery(myFormat);*/
			
			/*System.out.println("\naddNewPriceTier Query:");
			double thePrice = 3.99;
			PriceTier myPrice = new PriceTier(0, 10, "Classics", thePrice);
			DBAdder.addNewPriceTier(myPrice);*/
			
			/*System.out.println("\naddNewAccount Query:");
			Account myAccount = new Account(0, "Becca", "Low", "6042258898", "becca@hotmail.com", "BC", "North Vancouver", "V5G8U7", 
					"Canada", "Hoskins Rd", 0, 4717, "Registered Customer", "Active", 3.52, "carrot", "rice");
			DBAdder.addNewAccountQuery(myAccount);*/
			
			/*SubAccount mySub = new SubAccount(0, sqlDate, "Jenny", "Low", true, myAccount);
			System.out.println("\naddNewSubAccount Query:");
			DBAdder.addNewSubAccountQuery(mySub);*/
			
			/*Rental rental = Renter.rentMedia(myAccount, myCopy);
			System.out.println("\naddNewRental Query:");
			DBAdder.addNewRentalQuery(rental);*/
			
			/*Reservation reserve = Reserver.reserveMedia(myAccount, myCopy);
			System.out.println("\naddNewReserve Query:");
			DBAdder.addNewReservationQuery(reserve);*/
			
			myAccount.setFirstName("Jeff");
			myAccount.setLastName("Johnson");
			myAccount.setPhoneNumber("6047778585");
			myAccount.setEmail("jeff@hotmail.com");
			myAccount.setAppartmentNumber(12);
			myAccount.setPassPhrase("my phrases");
			
			System.out.println("\nsetAccount Query:");
			DBWriter.setAccountQuery(myAccount);
			
			
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
package com.nexvid.database_interface;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
			
			Account myAccount = DBReader.getAccountQuery(100000021);
			SubAccount mySub = new SubAccount(0, sqlDate, "Tiffany", "Smith", true, myAccount);
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			Media myMedia = new Media(0, "The Matrix 2", 0, 7, "Movie", mediaPrice, mediaFormat);
			//Media myTvShow = new Media(0, "Workaholics", 0, 72, "TV Show", mediaPrice, mediaFormat);
			MediaCopy myCopy = new MediaCopy(11, "Fast And Furious", 0, 13804, "Movie", mediaPrice, mediaFormat, 37, false, false, "New", true);
			//MediaCopy myTvShowCopy = new MediaCopy(0, "Workaholics", 0, 72, "TV Show", mediaPrice, mediaFormat, 0, false, false, "New", true);
			TvShowDisk tvShow = new TvShowDisk(0, "Breaking Bad", 0, 1396, "TV Show", mediaPrice, mediaFormat, 0, false, false, "New", true, 1, 3, 1);
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
			DBReader.getMediaQuery(157336);
			
			System.out.println("\ngetMediaByMediaID Query: ");
			DBReader.getMediaByMediaIDQuery(7);*/
			
			/*System.out.println("\nMediaCopies Query:");
			ArrayList<MediaCopy> mediaCopies = DBReader.getMediaCopiesQuery(1);
			for(int row = 0; row < mediaCopies.size(); row++){
				System.out.println(mediaCopies.get(row).getMediaCopyId() + ", " + mediaCopies.get(row).isRented() + ", " + mediaCopies.get(row).isReserved() + 
						", " + mediaCopies.get(row).getState() + ", " + mediaCopies.get(row).isActive() + ", " + mediaCopies.get(row).getMediaId() +
						", " + mediaCopies.get(row).getTitle() + ", " + mediaCopies.get(row).getTimesRented() + ", " + mediaCopies.get(row).getOnlineID() + 
						", " + mediaCopies.get(row).getType() + ", " + mediaCopies.get(row).getPrice().getPriceID() + ", " + 
						mediaCopies.get(row).getFormat().getFormatID());
			}*/
			
			
			/*System.out.println("\nMediaCopy Query:");
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
			
			/*System.out.println("\ngetRentalByCopyID Query: ");
			DBReader.getRentalByCopyIDQuery(4);*/
			
			/*AccountManager aManager = new AccountManager();
			aManager.getAccountReservations(myAccount);*/
			
			/*System.out.println("\ngetTvShowDisk Query: ");
			TvShowDisk myTvShow = DBReader.getTVShowDiskQuery(13);
			System.out.println("MediaID: "+ myTvShow.getMediaId() + "\nTitle: " + myTvShow.getTitle() + "\nPriceID: " +
					myTvShow.getPrice().getPriceID() + "\nFormatID: " + myTvShow.getFormat().getFormatID() + 
					"\nCopyID: " + myTvShow.getMediaCopyId() + "\nState: " + myTvShow.getState() + "\nSeason Number: " +
					myTvShow.getSeasonNumber() + "\nNumber of Episodes: " + myTvShow.getNumberOfEpisodes() + 
					"\nDisk Number: " + myTvShow.getDiskNumber());*/
			
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
			
			/*System.out.println("\naddNewFormat Query:");
			Format myFormat = new Format(0, "Beta");
			int formatID = DBAdder.addNewFormatQuery(myFormat);
			System.out.println("The returned ID is: " + formatID);*/
			
			/*System.out.println("\naddNewPriceTier Query:");
			double thePrice = 3.99;
			PriceTier myPrice = new PriceTier(0, 10, "Classics", thePrice);
			DBAdder.addNewPriceTier(myPrice);*/
			
			/*System.out.println("\naddNewAccount Query:");
			Account myAccount2 = new Account(0, "Sam", "Works", "6042259587", "SamWorks7@hotmail.com", "BC", "North Vancouver", "V5J8U7", 
					"Canada", "Definitely Rd", 0, 12, "Registered Customer", "Active", 0, "brazil", "cheap");
			DBAdder.addNewAccountQuery(myAccount2);*/
			
			/*System.out.println("\naddNewSubAccount Query:");
			int subID = DBAdder.addNewSubAccountQuery(mySub);
			System.out.println("The returned ID is: " + subID);
			
			System.out.println("\naddNewRental Query:");
			int rentalID = DBAdder.addNewRentalQuery(rental);
			System.out.println("The returned ID is: " + rentalID);*/
			/*myCopy.setMediaCopyId(8);
			rental.setMediaCopy(myCopy);
			DBAdder.addNewRentalQuery(rental);
			myCopy.setMediaCopyId(6);
			rental.setMediaCopy(myCopy);
			DBAdder.addNewRentalQuery(rental);
			myCopy.setMediaCopyId(1);
			rental.setMediaCopy(myCopy);
			DBAdder.addNewRentalQuery(rental);*/
			
			/*System.out.println("\naddNewRental Query: ");
			Rental myRental = new Rental(myAccount, myCopy);
			int rentalID = DBAdder.addNewRentalQuery(myRental);
			System.out.println(rentalID);*/
			/*Renter rent = new Renter();
			rent.rentMedia(myAccount.getAccountID(), myCopy.getMediaCopyId());*/
			
			/*System.out.println("\naddNewReserve Query:");
			int reservationID = DBAdder.addNewReservationQuery(reserve);
			System.out.println("The returned ID is: " + reservationID);*/
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
			
			/*System.out.println("\ngetActiveReservationByCopyID Query");
			DBReader.getReservationByCopyIDQuery(2);*/
			
			/*System.out.println("\naddTvShowDiskQuery Query: ");
			int mediaID = DBAdder.addNewMediaQuery(tvShow);
			tvShow.setMediaId(mediaID);
			int copyID = DBAdder.addMediaCopyQuery(tvShow);
			tvShow.setMediaCopyId(copyID);			
			DBAdder.addTvShowDiskQuery(tvShow);*/
			
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

			//Calendar cal1 = Calendar.getInstance();
			//Calendar cal2 = Calendar.getInstance();
			//cal2.set(1,1,24);
			//cal1.set(1,1,16);
			//Date tempDate1 = cal1.getTime();
			//Date tempDate2 = cal2.getTime();
			/*java.sql.Date databaseDate = today;//new java.sql.Date(tempDate1.getTime());
			java.sql.Date databaseDate2 = dateDue;//new java.sql.Date(tempDate2.getTime());
			
			Date testDate1 = databaseDate.valueOf(databaseDate.toString());
			Date testDate2 = databaseDate2.valueOf(databaseDate2.toString());
			
			System.out.println(testDate1);
			System.out.println(testDate2);
			
			long testValue = getDateDiff(testDate1, testDate2, TimeUnit.DAYS);
			System.out.println("The difference in time is "+ testValue + " days");*/
			
			System.out.println("\nRenterRent method: ");
			Renter renter = new Renter();
			int rentID = renter.rentMedia(100000016, 14);
			System.out.println(rentID);
			
			/*System.out.println("\nRenterReturn method: ");
			Renter renter = new Renter();
			renter.returnMedia(35);*/
			
			/*System.out.println("\nReserver Reserve: ");
			Reserver reserver = new Reserver();
			int reserveID = reserver.reserveMedia(100000016, 14);
			System.out.println(reserveID);*/
			
			/*System.out.println("\nReserver Cancel: ");
			Reserver reserver = new Reserver();
			boolean isCanceled = reserver.cancelReservation(4);
			System.out.println(isCanceled);*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit time)
	{
		long diffInTime = date2.getTime() - date1.getTime();
		return time.convert(diffInTime, TimeUnit.MILLISECONDS);
	}

}
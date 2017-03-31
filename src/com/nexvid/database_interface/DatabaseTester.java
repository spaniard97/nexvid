package com.nexvid.database_interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.accounts.Account;
import com.nexvid.inventory_manager.*;

public class DatabaseTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Account Query:");
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
			
			
			/*Uncomment to execute.  But change Media object as to not duplicate values
			System.out.println("\naddNewMedia Query:");
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			Media myMedia = new Media(0, "John Wick", 0, 4, "Movie", mediaPrice, mediaFormat);
			DBAdder.addNewMediaQuery(myMedia);
			
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");

			System.out.println("\naddMediaCopy Query:");
			MediaCopy myCopy = new MediaCopy(4, "John Wick", 0, 4, "Movie", mediaPrice, mediaFormat, 0, false, false, "New", true);
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

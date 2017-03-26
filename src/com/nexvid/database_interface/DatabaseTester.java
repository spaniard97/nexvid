package com.nexvid.database_interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.nexvid.inventory_manager.*;

public class DatabaseTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Account Query:");
			DBReader.getAccountQuery(100000004);
			
			System.out.println("\nSubAccount Query:");
			DBReader.getSubAccountQuery(3);
			
			System.out.println("\nMedia Query:");
			DBReader.getMediaQuery(2);
			
			System.out.println("\nMediaCopies Query:");
			DBReader.getMediaCopiesQuery(1);
			
			System.out.println("\nMediaCopy Query:");
			DBReader.getMediaCopyQuery(4);
			
			System.out.println("\naddNewMedia Query:");
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			Media myMedia = new Media(0, "The Godfater 3", 0, 3, "Movie", mediaPrice, mediaFormat);
			DBAdder.addNewMediaQuery(myMedia);;
			
			
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

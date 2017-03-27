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
			
			
			/* Uncomment to execute.  But change Media object as to not duplicate values
			 */
			//System.out.println("\naddNewMedia Query:");
			PriceTier mediaPrice = new PriceTier(1, 2, "New Release", 5.75);
			Format mediaFormat = new Format(1, "Blu-ray");
			//Media myMedia = new Media(0, "John Wick", 0, 4, "Movie", mediaPrice, mediaFormat);
			//DBAdder.addNewMediaQuery(myMedia);
			
			
			System.out.println("\naddMediaCopy Query:");
			MediaCopy myCopy = new MediaCopy(4, "John Wick", 0, 4, "Movie", mediaPrice, mediaFormat, 0, false, false, "New", true);
			DBAdder.addMediaCopyQuery(myCopy);
			
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

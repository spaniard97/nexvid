package com.nexvid.inventory_manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.accounts.*;
import com.nexvid.database_interface.DBAdder;
import com.nexvid.database_interface.DBReader;

/*import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.inventory_manager.Rental;*/

public class Tester {
	
	public static void main(String[] args) {
		
		
		int mediaID = InventoryManager.addNewMedia("The Fast and the Furious: Tokyo Drift", 9615, "Movie", 1, 1);
		
		/*
		try {
			PriceTier priceTier = DBReader.getPriceTier(1);
			Format format = DBReader.getFormat(1);
			
			Media newMedia = new Media(0, "Fast and Furious", 0, 13804, "Movie", priceTier, format);
			mediaID = DBAdder.addNewMediaQuery(newMedia);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		System.out.println(mediaID);
		
	}
	
}

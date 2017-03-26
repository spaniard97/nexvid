package com.nexvid.inventory_manager;

/**
 * The InventoryManager is responsible for the management of the inventory.
 * @author Samuel Pimenta
 * @since 03/19/2017
 * @version 1.0.0.1
 * 
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InventoryManager {
	
	/**
	 * Add copies to an existent media.
	 * @param media the media to add copies
	 * @param numberOfCopies the number of copies to be added
	 */
	public void addMediaCopies(Media media, int numberOfCopies){
		
	}
	
	/**
	 * Display the number of copies of a specific media.
	 * @param media The media selected
	 * @return the number of media copies
	 * @precondition the media must exist
	 * @postcondition the number of copies is returned as an integer
	 */
	public int getMediaCopies(Media media){
		return 0;
	}
	
	/**
	 * Create a Movie type MediaCopy object to be added to the inventory.
	 * @param JSONFromWebpage The media in JSON requested by manager to be added
	 * @precondition The Movie type MediaCopy must not exist
	 * @postcondition The Movie type MediaCopy object is created
	 */
	public void addMovie(JSONObject JSONFromWebpage) throws JSONException
	{
		int onlineID = (int)(JSONFromWebpage.get("Online ID"));
		int mediaID = 0;
		String title = JSONFromWebpage.getString("Movie Title");
		int notRented = 0;
		String mediaType = "";
		PriceTier moviePrice = null;
		Format movieFormat = null;		
	}
	
	/**
	 * Create a TvShow type MediaCopy object to be added to the inventory.
	 * @param media The media to be added
	 * @throws JSONException 
	 * @precondition The TvShow type MediaCopy must not exist
	 * @postcondition The TvShow type MediaCopy object is created
	 */
	public void addTvShow(JSONObject JSONFromWebpage) throws JSONException
	{
		int onlineID = (int)(JSONFromWebpage.get("Online ID"));
		int mediaID = 0;
		String title = JSONFromWebpage.getString("Movie Title");
		int notRented = 0;
		String mediaType = "";
		PriceTier moviePrice = null;
		Format movieFormat = null;
	}
	
	/**
	 * Deactivates an existing media.
	 * @param mediaToDeactivate media to be deactivated
	 * @precondition the media must exist and be active
	 * @postcondition the media is deactivated
	 */
	public void deactivateMedia(Media mediaToDeactivate){
		
	}
	
	/**
	 * Change the price of a price tier.
	 * @param price the new price of that tier
	 * @precondition The price tier must exist
	 * @postcondition The value of the price tier is modified
	 */
	public void modifyPriceTier(double price){
		
	}
	
	/**
	 * Get the value of a price tier.
	 * @return the value related to that price tier
	 * @precondition the price tier must exist
	 * @postcondition the value of the tier is returned as a double type
	 */
	public double getPriceTier(){
		return 0;
	}
	
	/**
	 * Add a new media format.
	 * @param format the media format to be added
	 * @precondition the media format must not exist
	 * @postcondition The media format is added
	 */
	public void addMediaFormat(String format){
		
	}
	
	/**
	 * This methods checks if a specific media is available.
	 * @param media to be checked
	 * @return true if the media is available
	 * @return false if media is not available
	 * @precondition the media object must exist
	 * @postcondition return true or false depending on the media availability
	 */
	public boolean isMediaAvailable(Media media){
		return false;
	}
	
}

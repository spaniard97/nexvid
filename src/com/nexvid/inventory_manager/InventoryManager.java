package com.nexvid.inventory_manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.nexvid.database_interface.DBAdder;
import com.nexvid.database_interface.DBReader;
import com.nexvid.database_interface.DBWriter;

/**
 * The InventoryManager is responsible for the management of the inventory.
 * @author Samuel Pimenta, Brian Chan, Juan Carlos Pinillos
 * @since 03/19/2017
 * @version 1.0.1.2
 * 
 */
@WebService(serviceName="InventoryManager")
public class InventoryManager {
	
	/**
	 * Add copies to an existent media.
	 * @param media the media to add copies
	 * @param numberOfCopies the number of copies to be added
	 */
	public void addMediaCopies(Media media, int numberOfCopies){
		/*ArrayList<MediaCopy> numOfMedia = null;
		try
		{
			numOfMedia = DBReader.getMediaCopiesQuery(media.getMediaId());
		}
		catch (SQLException | IOException e)
		{
			System.out.print("Error: Could not create media copies.");
		}
		int lastNumber = numOfMedia.size();*/
		
		for(int i = 1; i <= numberOfCopies; i++)
		{
			//int newCopy = i+lastNumber;
			MediaCopy mediaCopy = new MediaCopy(media.getMediaId(), media.getTitle(), media.getTimesRented(), media.getOnlineID(),
					media.getType(), media.getPrice(), media.getFormat(), 0, false, false, "New", true);
			try
			{
				DBWriter.setMediaCopyQuery(mediaCopy);
			}
			catch (IOException | SQLException e)
			{
				System.out.print("Error: Could not create media copies.");
			}
		}

	}
	
	/**
	 * Display the number of copies of a specific media.
	 * @param media The media selected
	 * @return the number of media copies
	 * @precondition the media must exist
	 * @postcondition the number of copies is returned as an integer
	 */
	@WebMethod(operationName="getMediaCopies")
	public String getMediaCopies(int mediaID){
		
		ArrayList<MediaCopy> mediaCopies = new ArrayList<MediaCopy>();
		String copies = "";
		
		try {
			mediaCopies = DBReader.getMediaCopiesQuery(mediaID);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < mediaCopies.size(); i++){
		
			copies += mediaCopies.get(i).mediaCopyToJSONString();
		}
		
		return copies;
	}

	
	/**
	 * Create a Movie type MediaCopy object to be added to the inventory.
	 * @param JSONFromWebpage The media in JSON requested by manager to be added
	 * @precondition The Movie type MediaCopy must not exist
	 * @postcondition The Movie type MediaCopy object is created
	 */
	/*
	public void addMovie(JSONObject JSONFromWebpage) throws JSONException
	{
		int onlineID = (int)(JSONFromWebpage.get("Online ID"));
		int mediaID = 0;
		String title = JSONFromWebpage.getString("Movie Title");
		int notRented = 0;
		String mediaType = "";
		PriceTier moviePrice = null;
		Format movieFormat = null;
		Media newMedia = new Media(mediaID, title, notRented, onlineID, mediaType, moviePrice, movieFormat);
		try
		{
			DBAdder.addNewMediaQuery(newMedia);
		}
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not add media");
		}
	}
	*/
	
	/**
	 * Create a TvShow type MediaCopy object to be added to the inventory.
	 * @param media The media to be added
	 * @throws JSONException 
	 * @precondition The TvShow type MediaCopy must not exist
	 * @postcondition The TvShow type MediaCopy object is created
	 */
	/*
	public void addTvShow(JSONObject JSONFromWebpage) throws JSONException
	{
		int onlineID = (int)(JSONFromWebpage.get("Online ID"));
		int mediaID = 0;
		String title = JSONFromWebpage.getString("Movie Title");
		int notRented = 0;
		String mediaType = "";
		PriceTier moviePrice = null;
		Format movieFormat = null;
		Media newMedia = new Media(mediaID, title, notRented, onlineID, mediaType, moviePrice, movieFormat);
		try
		{
			DBAdder.addNewMediaQuery(newMedia);
		}
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not add media");
		}
	}
	*/
	
	/**
	 * Deactivates an existing media.
	 * @param mediaToDeactivate media to be deactivated
	 * @precondition the media must exist and be active
	 * @postcondition the media is deactivated
	 */
	public void deactivateMedia(MediaCopy mediaToDeactivate){
		/*
		try
		{
			DBWriter.deactivate(mediaToDeactivate);
		} catch (IOException | SQLException e)
		{
			System.out.print("Error: Media could not be deactivated.");
		}
		*/
	}
	
	/**
	 * Change the price of a price tier.
	 * @param price the new price of that tier
	 * @precondition The price tier must exist
	 * @postcondition The value of the price tier is modified
	 */
	public void modifyPriceTier(PriceTier priceTier, double price){
		/*
		priceTier.setPrice(price);
		try
		{
			DBWriter.setPriceTierQuery(priceTier);
		}
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not change price tier.");
		}
		*/

	}
	
	/**
	 * Get the value of a price tier.
	 * @return the value related to that price tier
	 * @precondition the price tier must exist
	 * @postcondition the value of the tier is returned as a double type
	 */
	public double getPriceTier(PriceTier tier)
	{
		/*
		try
		{
			PriceTier priceTier = DBReader.getPriceTier(tier.getPriceID());
			return priceTier.getPrice();
		}
		catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not get price tier");
		}
		// Returns -1 if an error occurs
		 */
		return -1;
	}

	
	/**
	 * Add a new media format.
	 * @param format the media format to be added
	 * @precondition the media format must not exist
	 * @postcondition The media format is added
	 */
	public void addMediaFormat(String format){
		/*
		Format newFormat = new Format(0, format);
		try
		{
			DBAdder.addNewFormatQuery(newFormat);
		} catch (SQLException | IOException e)
		{
			System.out.print("Error: Could not add new format");
		}
		*/
	}
	
	/**
	 * This methods checks if a specific media is available.
	 * @param media to be checked
	 * @return true if the media is available
	 * @return false if media is not available
	 * @precondition the media object must exist
	 * @postcondition return true or false depending on the media availability
	 */
	public boolean isMediaAvailable(MediaCopy media)
	{
		/**
		if(media.isRented() == true)
		{
			return false;
		}
		*/
		return true;
	}

	/**
	 * 
	 * @param onlineId
	 * @return
	 */
	public static Media getMediaInformation(int onlineId){
		
		Media media = new Media();
		
		try {
			media = DBReader.getMediaQuery(onlineId);
					
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
		
		return media;
	}
	
	/**
	 * 
	 * @param mediaID
	 * @return
	 */
	public static Media getMediaInformationByID(int mediaID){
		
		Media media = new Media();
		
		try {
			media = DBReader.getMediaByMediaIDQuery(mediaID);
					
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
		
		return media;
	}
	
	/**
	 * 
	 * @param mediaCopyID
	 * @return
	 */
	public static MediaCopy getMediaCopyInformation(int mediaCopyID){
		
		MediaCopy mediaCopy = new MediaCopy();
		
		try {
			
			mediaCopy = DBReader.getMediaCopyQuery(mediaCopyID);
			
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
		
		return mediaCopy;
	}
	
	public static TvShowDisk getTvShowDiskInformation(int copyID){
		
		TvShowDisk tvShowDisk = new TvShowDisk();
		
		try {
			tvShowDisk = DBReader.getTVShowDiskQuery(copyID);
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
		
		return tvShowDisk;
	}
	
	/**
	 * 
	 * @param rentalID
	 * @return 
	 * @return
	 */
	@WebMethod(operationName="getRentalInformation")
	public String getRentalInformation(int rentalID){
		
		Rental rental = new Rental();
		
		try {
			rental = DBReader.getRentalQuery(rentalID);
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
		
		return rental.rentalToJSONString();
	}
	
	/**
	 * 
	 * @param mediaTitle
	 * @param mediaOnlineID
	 * @param mediaType
	 * @param mediaPriceID
	 * @param mediaFormatID
	 * @return
	 */
	@WebMethod(operationName="addNewMedia")
	public int addNewMedia(String mediaTitle, int mediaOnlineID, 
			String mediaType, int mediaPriceID, int mediaFormatID){
		
		Media newMedia = new Media();
		int newMediaID = 0;
		
		newMedia.setTitle(mediaTitle);
		newMedia.setOnlineID(mediaOnlineID);
		newMedia.setType(mediaType);
		newMedia.price.setPriceID(mediaPriceID);
		newMedia.format.setFormatID(mediaFormatID);
		
		try {
			
			newMediaID = DBAdder.addNewMediaQuery(newMedia);
			
			
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
		
		return newMediaID;
	}
	
	/**
	 * 
	 * @param mediaID
	 * @param mediaState
	 * @param numberOfCopies
	 * @return
	 */
	@WebMethod(operationName="addNewMediaCopy")
	public String addNewMediaCopy(int mediaID, String mediaState, int numberOfCopies){
		
		MediaCopy mediaCopy = new MediaCopy();
		String copyCreated = "";
		
		mediaCopy.setMediaId(mediaID);
		mediaCopy.setState(mediaState);
		
		for(int i = 0; i < numberOfCopies; i++){
			
			try {
				copyCreated += DBAdder.addMediaCopyQuery(mediaCopy) + ", ";
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
		}
		
		return copyCreated;
	}
	
	@WebMethod(operationName="getReservationInformation")
	public String getReservationInformation(int reservationID){
		
		Reservation reservation = new Reservation();
		
		try {
			reservation = DBReader.getReservationQuery(reservationID);
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
		
		return reservation.reservationToJSONString();
	}
	
}

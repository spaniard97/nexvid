package com.nexvid.inventory_manager;

/**The MediaCopy class acts as a copy of a media object
 * 
 * @author Brian Chan
 * @since 04/01/2017
 * @version 1.0.0.2
 *
 */
public class MediaCopy extends Media{
	public int mediaCopyId;
	public boolean isRented;
	public boolean isReserved;
	public String state;
	public boolean isActive;
	
	/**
	 * Default constructor
	 */
	public MediaCopy(){
		
	}
	
	/**
	 * Creates a default Movie copy.
	 * @param id The number that identifies the media
	 * @param mediaTitle The title of the media
	 * @param timesRented The number of times the media was rented
	 * @param mediaOnlineID The online Id of the media
	 * @param mediaType The type of media
	 * @param mediaPrice The price to rent the media
	 * @param mediaFormat The format of the media
	 */
	public MediaCopy(int id, String mediaTitle, int timesRented, int mediaOnlineID,
			String mediaType, PriceTier mediaPrice, Format mediaFormat){
		super(id, mediaTitle, timesRented, mediaOnlineID, mediaType, mediaPrice,
				mediaFormat);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a Movie copy with complete information.
	 * @param id The number that identifies the media
	 * @param mediaTitle The title of the media
	 * @param timesRented The number of times the media was rented
	 * @param mediaOnlineID The online Id of the media
	 * @param mediaType The type of media
	 * @param mediaPrice The price to rent the media
	 * @param mediaFormat The format of the media
	 * @param copyId The media copy Id
	 * @param rented True if media copy is rented
	 * @param reserved True if media copy is reserved
	 * @param copyStatus The current status of the copy 
	 * @param active True if movie copy is active
	 */
	public MediaCopy(int id, String mediaTitle, int timesRented, int mediaOnlineID,
			String mediaType, PriceTier mediaPrice, Format mediaFormat, int copyId, 
			boolean rented, boolean reserved, String copyState, boolean active){
		super(id, mediaTitle, timesRented, mediaOnlineID, mediaType, mediaPrice,
				mediaFormat);
		this.mediaCopyId = copyId;
		this.isRented = rented;
		this.isReserved = reserved;
		this.state = copyState;
		this.isActive = active;
	}
	
	/**
	 * Get a media's copy Id number.
	 * @return The media's copy Id number
	 */
	public int getMediaCopyId() {
		return this.mediaCopyId;
	}
	
	/**
	 * Set a media's copy Id number.
	 * @param mediaCopyId The media's copy Id number
	 */
	public void setMediaCopyId(int mediaCopyId) {
		this.mediaCopyId = mediaCopyId;
	}

	/**
	 * Checks if media copy is rented.
	 * @return True if media copy is rented
	 * @return False if the media copy is not rented
	 */
	public boolean isRented() {
		return isRented;
	}
	
	/**
	 * Set the rental status of a media's copy.
	 * @param isRented The rentals status of the media
	 */
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	
	/**
	 * Checks if media copy is reserved.
	 * @return True if media copy is reserved
	 * @return False if media copy is not reserved
	 */
	public boolean isReserved() {
		return isReserved;
	}

	/**
	 * Set the reserved status of a media's copy
	 * @param isReserved The reserved status of the media
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	
	/**
	 * Get the state of a media's copy.
	 * @return The state of the media's copy
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Set the state of a media's copy.
	 * @param state The state of a media's copy
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Checks if a media copy is active.
	 * @return True if media's copy is active
	 * @return False if the media's copy is deactivated
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Set a media to active or inactive.
	 * @param isActive The media active status
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}

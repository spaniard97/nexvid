package com.nexvid.inventory_manager;

/**
 * The Media class creates media objects.
 * @author Samuel Pimenta
 * @since 03/19/2017
 * @version 1.0.0.1
 *
 */
public class Media {
	
	protected int mediaId;
	protected String title;
	protected int timesRented;
	protected int onlineID;
	protected String type;
	protected PriceTier price;
	protected Format format;
	
	
	/**
	 * Creates a Media object.
	 * 
	 * @param id The number that identifies the media
	 * @param mediaTitle The title of the media
	 * @param timesRented The number of times the media was rented
	 * @param mediaOnlineID The online Id of the media
	 * @param mediaType The type of media
	 * @param mediaPrice The price to rent the media
	 * @param mediaFormat The format of the media
	 */
	public Media(int id, String mediaTitle, int  timesRented,int mediaOnlineID, 
			String mediaType, PriceTier mediaPrice, Format mediaFormat){
		this.mediaId = id;
		this.title = mediaTitle;
		this.timesRented = timesRented;
		this.onlineID = mediaOnlineID;
		this.type = mediaType;
		this.price = mediaPrice;
		this.format = mediaFormat;
	}

	/**
	 * Get the Id of a media.
	 * @return The Id of the media
	 */
	public int getMediaId() {
		return this.mediaId;
	}

	/**
	 * Set the Id of a media.
	 * @param mediaId The Id of the media
	 */
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * Get the media's title.
	 * @return title The title of the media
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Set the media's title.
	 * @param title The title of the media
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the amount of times the media was rented.
	 * @return timesRented The amount of times the media was rented
	 */
	public int getTimesRented() {
		return this.timesRented;
	}

	/**
	 * Set the amount of times the media was rented.
	 * @param timesRented The amount of times the media was rented
	 */
	public void setTimesRented(int timesRented) {
		this.timesRented = timesRented;
	}

	/**
	 * Get the online Id of a media.
	 * @return onlineID The online Id of a media
	 */
	public int getOnlineID() {
		return this.onlineID;
	}

	/**
	 * Set the online Id of a media
	 * @param onlineID The online Id of a media
	 */
	public void setOnlineID(int onlineID) {
		this.onlineID = onlineID;
	}

	/**
	 * Get the type of media, either Movie or TVShow.
	 * @return type The media's type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Set the type of media, either Movie or TvShow.
	 * @param type The media's type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get a media's rental price
	 * @return price The media's rental price
	 */
	public PriceTier getPrice() {
		return this.price;
	}

	/**
	 * Set a media's rental price.
	 * @param price The media's rental price
	 */
	public void setPrice(PriceTier price) {
		this.price = price;
	}

	/**
	 * Get a media's format.
	 * @return format The media's format
	 */
	public Format getFormat() {
		return this.format;
	}

	/**
	 * Set a media's format.
	 * @param format The media's format
	 */
	public void setFormat(Format format) {
		this.format = format;
	}
}

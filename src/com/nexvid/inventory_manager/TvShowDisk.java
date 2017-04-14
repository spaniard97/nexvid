package com.nexvid.inventory_manager;

/**The TvShowDisk class is used to identify the diskID and the disk information
 * 
 * @author Brian Chan, Juan Carlos Pinillos
 * @since 04/01/2017
 * @version 1.0.1.2
 *
 */
public class TvShowDisk extends MediaCopy{
	
	public int seasonNumber;
	public int numberOfEpisodes;
	public int diskNumber;
	
	/**
	 * Default Constructor
	 */
	public TvShowDisk(){
		
	}
	
	/**
	 * Creates a minimal TvShowDisk .
	 * @param id The number that identifies the media
	 * @param mediaTitle The title of the media
	 * @param timesRented The number of times the media was rented
	 * @param mediaOnlineID The online Id of the media
	 * @param mediaType The type of media
	 * @param mediaPrice The price to rent the media
	 * @param mediaFormat The format of the media
	 * @param copyId The TvShow copy Id
	 * @param rented True if TvShow copy is rented
	 * @param reserved True if TvShow copy is reserved
	 * @param copyStatus The current status of the copy 
	 * @param active True if TvShow copy is active
	 */
	public TvShowDisk(int id, String mediaTitle, int timesRented,
			int mediaOnlineID, String mediaType, PriceTier mediaPrice,
			Format mediaFormat, int copyId, boolean rented, boolean reserved,
			String copyStatus, boolean active) {
		super(id, mediaTitle, timesRented, mediaOnlineID, mediaType, mediaPrice,
				mediaFormat, copyId, rented, reserved, copyStatus, active);
	}
	
	/**
	 * Creates a TvShowDisk with complete information.
	 * @param id The number that identifies the media
	 * @param mediaTitle The title of the media
	 * @param timesRented The number of times the media was rented
	 * @param mediaOnlineID The online Id of the media
	 * @param mediaType The type of media
	 * @param mediaPrice The price to rent the media
	 * @param mediaFormat The format of the media
	 * @param copyId The TvShow copy Id
	 * @param rented True if TvShow copy is rented
	 * @param reserved True if TvShow copy is reserved
	 * @param copyStatus The current status of the copy 
	 * @param active True if TvShow copy is active
	 * @param numberOfTheSeason The TvShow's season number
	 * @param episodesInDisk How many episodes are in the disk
	 * @param numberOfTheDisk Number of the disk in that season
	 */
	public TvShowDisk(int id, String mediaTitle, int timesRented,
			int mediaOnlineID, String mediaType, PriceTier mediaPrice,
			Format mediaFormat, int copyId, boolean rented, boolean reserved,
			String copyStatus, boolean active, int numberOfTheSeason, int episodesInDisk, int numberOfTheDisk){
		super(id, mediaTitle, timesRented, mediaOnlineID, mediaType, mediaPrice,
				mediaFormat, copyId, rented, reserved, copyStatus, active);
		this.seasonNumber = numberOfTheSeason;
		this.numberOfEpisodes = episodesInDisk;
		this.diskNumber = numberOfTheDisk;
	}

	/**
	 * Get a season of a TvShow disk.
	 * @return The season number
	 */
	public int getSeasonNumber() {
		return this.seasonNumber;
	}

	/**
	 * Set the season number of a TvShow disk
	 * @param seasonNumber The season number
	 */
	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	/**
	 * Get the number of episodes in a TvShow disk
	 * @return The number of episodes in the disk
	 */
	public int getNumberOfEpisodes() {
		return this.numberOfEpisodes;
	}

	/**
	 * Set the number of episodes in a TvShowDisk
	 * @param numberOfEpisodes The number of episodes in the disk
	 */
	public void setNumberOfEpisodes(int numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	/**
	 * Get the disk number of a TvShow disk.
	 * @return The disk number of the TvShow disk
	 */
	public int getDiskNumber() {
		return this.diskNumber;
	}

	/**
	 * Set the disk number of a TvShow disk.
	 * @param diskNumber The disk number of the TvShow disk
	 */
	public void setDiskNumber(int diskNumber) {
		this.diskNumber = diskNumber;
	}

}

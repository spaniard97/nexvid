package com.nexvid.inventory_manager;

public class TvShowDisk extends MediaCopy{
	
	public int seasonNumber;
	public int numberOfEpisodes;
	public int diskNumber;
	
	/**
	 * Creates a default TvShowDisk .
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
		// TODO Auto-generated constructor stub
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
	}

	/**
	 * Get a season of a TvShow disk.
	 * @return The season number
	 */
	public int getSeasonNumber() {
		return seasonNumber;
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
		return numberOfEpisodes;
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
		return diskNumber;
	}

	/**
	 * Set the disk number of a TvShow disk.
	 * @param diskNumber The disk number of the TvShow disk
	 */
	public void setDiskNumber(int diskNumber) {
		this.diskNumber = diskNumber;
	}

}

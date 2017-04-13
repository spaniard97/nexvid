package com.nexvid.inventory_manager;

import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.database_interface.DBReader;

/**
 * The MediaSercher class is responsible for searching medias in our database.
 * @author Samuel Pimenta
 * @since 03/20/2017
 * @version 1.0.0.0
 *
 */
public class MediaSearcher {

	/**
	 * Searches for a media in our database.
	 * @param onlineId The media's online id to be searched in our database
	 * @return The media object
	 * @precondition the onlineId must exist
	 * @postcondition A media object is returned
	 */
	public Media searchMedia(int onlineId)
	{
		Media searchedMedia;
		try
		{
			searchedMedia = DBReader.getMediaQuery(onlineId);
			return searchedMedia;
		} catch (IOException | SQLException e)
		{
			System.out.print("Error: Could not search for a media.");
		}
		return null;
	}
}

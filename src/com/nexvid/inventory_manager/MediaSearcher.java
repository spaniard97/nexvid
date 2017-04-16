package com.nexvid.inventory_manager;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * The MediaSercher class is responsible for searching medias in our database.
 * @author Samuel Pimenta
 * @since 03/20/2017
 * @version 1.0.0.0
 *
 */
@WebService(serviceName="MediaSearcher")
public class MediaSearcher {

	/**
	 * Searches for a media in our database based on the online ID.
	 * @param onlineId The media's online ID to be searched in our database
	 * @return The media object
	 * @precondition the onlineId must exist
	 * @postcondition A media object is returned
	 */
	@WebMethod(operationName="searchMedia") 
	public String searchMedia(int onlineId){
		
		Media media = InventoryManager.getMediaInformation(onlineId);
		
		return media.mediaToJSONString();
	}
	
	@WebMethod(operationName="SearchMediaCopy")
	public String searchMediaCopy(int mediaCopyId){
		
		MediaCopy mediaCopy = InventoryManager.getMediaCopyInformation(mediaCopyId);
		
		return mediaCopy.mediaCopyToJSONString();
	}
	
	
	@WebMethod(operationName="searchMediaByID") 
	public String searchMediaByID(int mediaID){
		
		Media media = InventoryManager.getMediaInformationByID(mediaID);
		
		return media.mediaToJSONString();
	}
	
	@WebMethod(operationName="searchTvShowDiskInformation") 
	public String searchTvShowDiskInformation(int copyID){
		
		TvShowDisk tvShowDisk = InventoryManager.getTvShowDiskInformation(copyID);
		
		return tvShowDisk.tvShowDiskToJSONString();
	}
}

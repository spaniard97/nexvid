package com.nexvid.inventory_manager;

/**
 * The Format class creates Format objects.
 * @author Juan Carlos Pinillos
 */
public class Format {
	
	protected String formatID;
	protected String type;
	
	/**
	 * Create a Format object
	 * 
	 * @param formatID the number that identifies the format
	 * @param type the name of the format
	 */
	public Format(String formatID, String type){
		setFormatID(formatID);
		setType(type);
	}
	
	/**
	 * Get the ID of the format
	 * @return the ID of the format
	 */
	public String getFormatID() {
		return formatID;
	}

	/**
	 * Set the ID of the format
	 * @param formatID the ID of the format
	 */
	public void setFormatID(String formatID) {
		this.formatID = formatID;
	}

	/**
	 * Get the type name of the format
	 * @return the type name of the format
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type name of the format
	 * @param type the type name of the format
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}

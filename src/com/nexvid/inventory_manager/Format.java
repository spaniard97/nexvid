package com.nexvid.inventory_manager;

/**
 * The Format class creates Format objects.
 * @author Juan Carlos Pinillos
 */
public class Format {
	
	protected int formatID;
	protected String type;
	
	public Format(){
		//this.formatID = 0;
		//this.type = null;
	}
	
	/**
	 * Create a Format object
	 * 
	 * @param formatID the number that identifies the format
	 * @param type the name of the format
	 */
	public Format(int formatID, String type){
		this.formatID = formatID;
		this.type = type;
	}
	
	/**
	 * Get the ID of the format
	 * @return the ID of the format
	 */
	public int getFormatID() {
		return formatID;
	}

	/**
	 * Set the ID of the format
	 * @param formatID the ID of the format
	 */
	public void setFormatID(int formatID) {
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

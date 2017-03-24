package com.nexvid.inventory_manager;

/**
 * The PriceTier class creates PriceTier objects.
 * @author Juan Carlos Pinillos
 */
public class PriceTier {
	
	protected int priceID;
	protected int rentalPeriod;
	protected String priceTier;
	protected double price;
	
	/**
	 * Creates a PriceTier object
	 * 
	 * @param priceID the number that identifies the price tier 
	 * @param rentalPeriod the number of days for the rental
	 * @param priceTier the name of rental price tier eg. "New Release"
	 * @param price the dollar amount of the price tier
	 */
	public PriceTier(int priceID, int rentalPeriod, String priceTier, double price){
		
	}
	
	/**
	 * get the ID of the price tier
	 * @return the ID of the price tier
	 */
	public int getPriceID() {
		return priceID;
	}

	/**
	 * Set the ID of the price tier
	 * @param priceID the ID of the price tier
	 */
	public void setPriceID(int priceID) {
		this.priceID = priceID;
	}

	/**
	 * Get the rental period of the price tier
	 * @return the rental period of the price tier
	 */
	public int getRentalPeriod() {
		return rentalPeriod;
	}

	/**
	 * Set the rental period of the price tier
	 * @param rentalPeriod the rental period of the price tier
	 */
	public void setRentalPeriod(int rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}

	/**
	 * Get the price tier name of the price tier
	 * @return the price tier name of the price tier
	 */
	public String getPriceTier() {
		return priceTier;
	}

	/**
	 * Set the price tier name of the price tier
	 * @param priceTier the price tier name of the price tier
	 */
	public void setPriceTier(String priceTier) {
		this.priceTier = priceTier;
	}

	/**
	 * Get the price of the price tier
	 * @return the price of the price tier
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the price of the price tier
	 * @param price the price of the price tier
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
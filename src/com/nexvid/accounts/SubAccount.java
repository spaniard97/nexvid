package com.nexvid.accounts;

import java.util.Date;
/**The subaccount class holds the subaccount's information
 * 
 * @author Brian Chan
 * @since 04/01/2017
 * @version 1.0.1.2
 *
 */
public class SubAccount
{
	protected int subAccountID;
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected boolean isActive;
	protected Account account;
    
	/**
	 * Default constructor
	 */
	public SubAccount(){
		
	}
	
	/**
     * Constructs a SubAccount
     * @param subAccountID the sub account ID
     * @param firstname the sub account holder's first name
     * @param lastname the sub account holder's last name
     * @param dateOfBirth the sub account holder date of birth
     * @param active the sub account status
     * @param accountID the sub account's parent's account ID
     */
    public SubAccount(int subAccountID, Date dateOfBirth, String firstName, String lastName, boolean active, Account account)
    {
    	this.subAccountID = subAccountID;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.dateOfBirth = dateOfBirth;
    	this.isActive = active;
    	this.account = account;
    	
    }
	
	/**
	 * Gets the sub account ID.
	 * @return The sub account ID
	 */
    public int getSubAccountID()
    {
        return this.subAccountID;
    }
    
    /**
     * Sets the sub account ID.
     * @param account_ID The sub account ID to be set
     */
    public void setSubAccountID(int subAccountID)
    {
        this.subAccountID = subAccountID;
    }

    /**
     * Gets the sub account holder's name.
     * @return The sub account holder's first name
     */
    public String getFirstName()
    {
        return this.firstName;
    }
    
    /**
     * Sets the sub account holder's first name.
     * @param first_name the first name to be set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the sub account holder's last name.
     * @return the sub account holder's last name
     */
    public String getLastName()
    {
        return this.lastName;
    }
    
    /**
     * Sets the sub account holder's last name.
     * @param last_name the last name to be set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the sub account holder's date of birth.
     * @return The sub account holder's date of birth
     */
    public Date getDateOfBirth()
    {
        return this.dateOfBirth;
    }
    
    /**
     * Sets the sub account holder's date of birth.
     * @param dateOfBirth The date of birth to be set
     */
    public void setDateOfBirth(Date dateOfBirth){
    	this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the sub account status.
     * @return True if sub account is active
     * @return False if sub account is inactive
     */
    public boolean isActive()
    {
        return this.isActive;
    }

    /**
     * Sets the status of the sub account.
     * @param active The status to be set
     */
    public void setActive(boolean active)
    {
        this.isActive = active;
    }
    
    /**
     * Gets the parent's account ID
     * @return the parent's account ID
     */
	public Account getAccount() {
		return this.account;
	}
	
	/**
	 * Sets the accountID to the parent's account ID
	 * @param accountID the parent's accountID
	 */
	public void setAccount(Account account){
		this.account = account;
	}
	
	public String SubAccountToJSONString() {
    	
    	String _JSON =  "{\"subAccountId\":\"" + this.subAccountID + "\"," +
    			"\"subAccountFirstName\":\"" + this.firstName + "\"," +
    			"\"subAccountLastName\":\"" + this.lastName + "\"," +
    			"\"subAccountDOB\":\"" + this.dateOfBirth + "\"," +
    			"\"subAccountActive\":\"" + this.isActive + "\"," +
    			"\"accountID\":\"" + this.account.accountID + "\","
    			+ "\"firstName\":\"" + this.account.firstName + "\"," + 
    			"\"lastName\":\"" + this.account.lastName + "\"," + 
    			"\"phoneNumber\":\"" + this.account.phoneNumber + "\"," + 
    			"\"email\":\"" + this.account.email + "\"," + 
    			"\"province\":\"" + this.account.province + "\"," +
    			"\"city\":\"" + this.account.city + "\"," +
    			"\"postalCode\":\"" + this.account.postalCode + "\"," +
    			"\"country\":\"" + this.account.country + "\"," +
    			"\"streetName\":\"" + this.account.streetName + "\"," +
    			"\"apartmentNumber\":\"" + this.account.apartmentNumber + "\"," +
    			"\"streetNumber\":\"" + this.account.streetNumber + "\"," +
    			"\"accountType\":\"" + this.account.accountType + "\"," +
    			"\"status\":\"" + this.account.status + "\"," +
    			"\"balanceOwed\":\"" + this.account.balanceOwed + "\"," +
    			"\"password\":\"" + this.account.password + "\"," +
    			"\"passPhrase\":\"" + this.account.passPhrase + "\"" +
    			"}";
    	
    	return _JSON;
    }

}
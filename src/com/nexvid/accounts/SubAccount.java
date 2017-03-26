package com.nexvid.accounts;

import java.util.Date;

public class SubAccount
{
	protected int subAccountID;
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected boolean isActive;
    
	/**
     * Constructs a SubAccount
     * @param account_ID the parent account ID
     * @param first_name the sub account holder's first name
     * @param last_name the sub account holder's last name
     * @param d_o_b the sub account holder date of birth
     * @param active the sub account status
     */
    public SubAccount(int subAccountID, String firstName, String lastName, Date dateOfBirth, boolean active)
    {
    	this.subAccountID = subAccountID;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.dateOfBirth = dateOfBirth;
    	this.isActive = active;
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
    public void setAccountID(int subAccountID)
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
        return isActive;
    }

    /**
     * Sets the status of the sub account.
     * @param active The status to be set
     */
    public void setActive(boolean active)
    {
        this.isActive = active;
    }
     
}
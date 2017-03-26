package com.nexvid.accounts;


public class Account 
{
	protected int accountID;
	protected String firstName;
	protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected String province;
    protected String city;
    protected String postalCode;
    protected String country;
    protected String streetName;
    protected int apartmentNumber;
    protected int streetNumber;
    protected String accountType;
    protected String status;
    protected double balanceOwed;
	protected String password;
	protected String passPhrase;
	protected SubAccount subAccount;
    
    /**
     * Creates an Account with minimal information.
     * @param accountID The account ID
     * @param firstName The account holder's first name
     * @param lastName The account holder's last name
     * @param phoneNumber The account holder's phone number
     * @param province The account holder's province of residence
     * @param city The account holder's city of residence
     * @param postalCode The account holder's postal code
     * @param country The account holder's country of residence
     * @param streetName The account holder's street name
     * @param streetNumber The account holder's street number
     * @param accountType The account holder's account type
     * @param status The account status
     * @param password The account password
     */
	public Account(int accountID, String firstName, String lastName, String phoneNumber, String province,
			String city, String postalCode, String country, String streetName, int streetNumber, 
			String accountType, String status, String password)
	{
		this.accountID = accountID;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.phoneNumber = phoneNumber;
    	this.province = province;
    	this.city = city;
    	this.postalCode = postalCode;
    	this.country = country;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.accountType = accountType;
		this.status = status;
		this.balanceOwed = 0;
		this.password = password;
	}
	
	
	/**
	 * Creates an Account with all information.
	 * @param accountID The account ID
     * @param firstName The account holder's first name
     * @param lastName The account holder's last name
     * @param phoneNumber The account holder's phone number
	 * @param email The account holder's email
	 * @param province The account holder's province of residence
     * @param city The account holder's city of residence
     * @param postalCode The account holder's postal code
     * @param country The account holder's country of residence
     * @param streetName The account holder's street name
	 * @param apartmentNumber The account holder's apartment number
	 * @param streetNumber The account holder's street number
     * @param accountType The account holder's account type
     * @param status The account status
     * @param password The account password
	 * @param passPhrase The account holder's pass phrase
	 * @param subAccount The account holder's sub account information
	 */
    public Account(int accountID, String firstName, String lastName, String phoneNumber, String email, 
    		String province, String city, String postalCode, String country, String streetName, int apartmentNumber, 
    		int streetNumber, String accountType, String status, String password, String passPhrase, 
    		SubAccount subAccount) 
    {
    	this.accountID = accountID;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.phoneNumber = phoneNumber;
    	this.email = email;
    	this.province = province;
    	this.city = city;
    	this.postalCode = postalCode;
    	this.country = country;
		this.streetName = streetName;
		this.apartmentNumber = apartmentNumber;
		this.streetNumber = streetNumber;
		this.accountType = accountType;
		this.status = status;
		this.balanceOwed = 0;
		this.password = password;
		this.passPhrase = passPhrase;
		this.subAccount = subAccount;
	}
    
    /**
	 * Gets a account holder's first name
	 * @return The account holder's first name
	 */
	public String getFirstName()
	{
	    return null;
	}
    
	/**
	 * Sets a account holder's last name.
	 * @param lastName The account holder's last name
	 */
	public void setLastName(String lastName)
	{

	}
	
	/**
	 * Gets a account holder's last name
	 * @return The account holder's last name
	 */
	public String getLastName()
	{
	    return null;
	}
	
	/**
	 * Sets a account holder's first name.
	 * @param firstName The account holder's first name
	 */
	public void setFirstName(String firstName)
	{

	}
	
	/**
	 * Gets the account ID.
	 * @return The accountID
	 */
	public int getAccountID()
	{
		return 0;
	}
	
	/**
	 * Sets the new account ID.
	 * @param accountID The accountID to set
	 */
	public void setAccountID(int accountID)
	{
		this.accountID = accountID;
	}
	
	/**
	 * Gets the current account password.
	 * @return The account password
	 */
	public String getPassword()
	{
		return null;
	}
	
	/**
	 * Sets the new account password.
	 * @param password The password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
     * Gets the account type.
     * @return The account type
     */
    public String getAccountType()
    {
        return this.accountType;
    }
    
    /**
     * Sets the account type.
     * @param type The account type
     */
    public void setAccountType(String type)
    {
    	this.accountType = type;
    }
	
    /**
     * Gets the account holder's street name.
     * @return The account holder's street name
     */
    public String getStreetName() {
		return streetName;
	}
    
    /**
     * Sets the account holder's street name.
     * @param streetName The account holder's street name
     */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	/**
	 * Gets the account holder's apartment number.
	 * @return The account holder's apartment number
	 */
	public int getAppartmentNumber() {
		return apartmentNumber;
	}
	
	/**
	 * Sets the account holder's apartmentNumber.
	 * @param apartmentNumber
	 */
	public void setAppartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	/**
	 * Gets the account holder's street number.
	 * @return The account holder's street number
	 */
	public int getStreetNumber() {
		return streetNumber;
	}
	
	/**
	 * Sets the account holder's street number.
	 * @param streetNumber The account holder's street number
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	/**
	 * Gets the account holder's city of residence.
	 * @return The account holder's city of residence
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the account holder's city of residence.
	 * @param city The account holder's city of residence
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the account holder's province of residence.
	 * @return The account holder's province of residence
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Sets the account holder's province of residence
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * Gets the account holder's country of residence.
	 * @return The account holder's country of residence
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the account holder's country of residence
	 * @param country The account holder's country of residence
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Gets the account holder's phone number.
     * @return The account holder's phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Sets the account holder's phone number
     * @param phoneNumber The phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Gets the account holder's email.
     * @return The account holder's email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Sets the account holder's email
     * @param email The email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Gets the account status.
     * @return The account status
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * Sets the accounts status.
     * @param The account status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * Gets the account's owing balance..
     * @return The account's balance owed
     */
    public double getBalanceOwed()
    {
        return balanceOwed;
    }
    
    /**
     * Sets the account's owing balance
     * @param balanceOwed The balance that the account holder owes
     */
    public void setBalanceOwed(double balanceOwed)
    {
        this.balanceOwed = balanceOwed;
    }
    
    /**
     * Gets the account holder's pass phrase
     * @return The account holder's pass phrase
     */
    public String getPassPhrase()
    {
        return passPhrase;
    }
    
    /**
     * Sets the customer's pass phrase
     * @param passPhrase The pass phrase for sub accounts
     */
    public void setPassPhrase(String passPhrase)
    {
        this.passPhrase = passPhrase;
    }
    
    /**
     * Gets the account holder's sub account information
     * @param subAccount The account holder's sub account
     * @return The sub account information
     */
    public SubAccount getSubAccount(SubAccount subAccount)
    {
    	return subAccount;
    }
    /**
     * Sets the account holder's sub account information
     * @param subAccount The account holder's sub account to be set
     */
    
    public void setSubAccount(SubAccount subAccount)
    {
    	this.subAccount = subAccount;
    }
	
}

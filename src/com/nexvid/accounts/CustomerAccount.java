package com.nexvid.accounts;

public class CustomerAccount extends Account
{
    private String streetName;
    private String appartmentNumber;
    private int streetNumber;
    private String city;
    private String province;
    private String country;
    private String phoneNumber;
    private String email;
    private String status;
    private Balance balanceOwed;
    private String passPhrase;
    private String accountType;
    
    protected String getAccountType()
    {
        return this.accountType;
    }
    
    protected void setAccountType(String accountType)
    {
    	this.accountType = accountType;
    }
    
    
    protected String getStreetName() {
		return streetName;
	}
	protected void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	protected String getAppartmentNumber() {
		return appartmentNumber;
	}
	protected void setAppartmentNumber(String appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}
	protected int getStreetNumber() {
		return streetNumber;
	}
	protected void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	protected String getCity() {
		return city;
	}
	protected void setCity(String city) {
		this.city = city;
	}
	protected String getProvince() {
		return province;
	}
	protected void setProvince(String province) {
		this.province = province;
	}
	protected String getCountry() {
		return country;
	}
	protected void setCountry(String country) {
		this.country = country;
	}
	/**
     * @return the customer's phoneNumber
     */
    protected String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
     * @return the customer's email
     */
    protected String getEmail()
    {
        return email;
    }
    /**
     * @return the boolean of the customer account's confirmation status
     */
    protected String getStatus()
    {
        return status;
    }
    /**
     * @return the customer's balanceOwed
     */
    protected Balance getBalanceOwed()
    {
        return balanceOwed;
    }
    /**
     * @return the customer's passPhrase
     */
    protected String getPassPhrase()
    {
        return passPhrase;
    }
    /**
     * Sets the customer's phone number
     * @param phoneNumber the phoneNumber to set
     */
    protected void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Sets the customer's email
     * @param email the email to set
     */
    protected void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * Sets the accounts confirmation status
     * @param confirmed the confirmation of the account
     */
    protected void setStatus(String status)
    {
        this.status = status;
    }
    /**
     * Sets the customer's owing balance
     * @param balanceOwed the balance that the customer owes
     */
    protected void setBalanceOwed(Balance balanceOwed)
    {
        this.balanceOwed = balanceOwed;
    }
    /**
     * Sets the customer's passphrase
     * @param passPhrase the passphrase for sub accounts
     */
    protected void setPassPhrase(String passPhrase)
    {
        this.passPhrase = passPhrase;
    }

    /**
     * 
     * @param streetName name of customer's street
     * @param appartmentNumber customer's apartment number
     * @param streetNumber customer's street number
     * @param city customer's city of residence
     * @param province customer's province of residence
     * @param country customer's country of residence
     * @param phoneNumber customer's phone number
     * @param email customer's email
     * @param status the status of customer's account
     * @param passPhrase passphrase for subaccounts
     */
    public CustomerAccount(String streetName, String appartmentNumber, int streetNumber, String city, String province,
			String country, String phoneNumber, String email, String status,
			String passPhrase) {
		super();
		this.streetName = streetName;
		this.appartmentNumber = appartmentNumber;
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		this.passPhrase = passPhrase;
		this.accountType = "RegisteredCustomer";
	}
    
    
    
    
    
    
    
    
    
}

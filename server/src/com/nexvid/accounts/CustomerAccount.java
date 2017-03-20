package com.nexvid.accounts;

public class CustomerAccount extends Account
{
    private String address;
    private String phoneNumber;
    private String email;
    private Boolean confirmed;
    private Balance balanceOwed;
    private String passPhrase;
    
    /**
     * @return the customer's address
     */
    protected String getAddress()
    {
        return address;
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
    protected Boolean getConfirmed()
    {
        return confirmed;
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
     * Sets the customer's address
     * @param address the customer's address
     */
    protected void setAddress(String address)
    {
        this.address = address;
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
     * only necessary for online registration
     * @param confirmed the confirmation of the account
     */
    protected void setConfirmed(Boolean confirmed)
    {
        this.confirmed = confirmed;
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
     * @param address the customer's address
     * @param phoneNumber the customer's phone number
     * @param email the customer's email
     * @param confirmed the customer's account confirmation status
     * @param passPhrase the customer's account passphrase
     */
    public CustomerAccount(String address, String phoneNumber, String email, Boolean confirmed, Balance balanceOwed,
            String passPhrase)
    {
	super();
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.confirmed = confirmed;
	this.passPhrase = passPhrase;
    }
    
    
    
}

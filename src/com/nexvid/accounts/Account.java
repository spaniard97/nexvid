package com.nexvid.accounts;

class Account {

	private String firstName;
	private String lastName;
	private int accountID;
	private String password;
	
	
	
	
	private void setLastName(String lastName)
	{
	    this.lastName = lastName;
	}
	
	private void setFirstName(String firstName)
	{
	    this.firstName = firstName;
	}
	
	protected String getFirstName()
	{
	    return this.firstName;
	}
	
	protected String getLastName()
	{
	    return this.lastName;
	}
	
	/**
	 * Gets the account ID
	 * @return the accountID
	 */
	protected int getAccountID() {
		return accountID;
	}
	
	/**
	 * Gets the current account password
	 * @return the password
	 */
	protected String getPassword() {
		return password;
	}
	
	/**
	 * Sets the account owner's name
	 * @param firstName the account owner's first name
	 * @param lastName the account owner's last name
	 */
	protected void setName(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	/**
	 * Sets the new account ID
	 * @param accountID the accountID to set
	 */
	protected void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	/**
	 * Sets the new account password
	 * @param password the password to set
	 */
	protected void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}

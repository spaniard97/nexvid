package com.nexvid.accounts;

class Account {

	private String name;
	private int accountID;
	private String password;
	
	
	/**
	 * Gets the account owner's name
	 * @return the name
	 */
	protected String getName() {
		return name;
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
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
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

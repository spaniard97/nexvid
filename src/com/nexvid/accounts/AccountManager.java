package com.nexvid.accounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.nexvid.database_interface.DBAdder;
import com.nexvid.database_interface.DBReader;
import com.nexvid.database_interface.DBWriter;
import com.nexvid.inventory_manager.*;

/**
 * The AccountMAnager class is responsible for all account based actions
 * @author Brian Chan, Juan Carlos Pinillos
 * @since 03/18/2017
 * @version 1.0.1.4
 *
 */
@WebService (serviceName="AccountManager") 
public class AccountManager
{
	
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
	public Account createAccountMinimum(int accountID, String firstName, String lastName, String phoneNumber, String province,
			String city, String postalCode, String country, String streetName, int streetNumber, 
			String accountType, String status, String password)
	{
		return new Account(accountID, firstName, lastName, phoneNumber, province,
				city, postalCode, country, streetName, streetNumber, 
				accountType, status, password);

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
	 */
	@WebMethod(operationName="createAccount") 
    public int createAccount(String firstName, String lastName, String phoneNumber, 
    		String email, String province, String city, String postalCode, String country, String streetName, 
    		int apartmentNumber, int streetNumber, String accountType, String status, String password, 
    		String passPhrase) 
    {
    	
    	/*Account account = new Account(accountID,firstName,lastName,phoneNumber,
    			email,province,city,postalCode,country,streetName,apartmentNumber,
    			streetNumber,accountType,status,password,passPhrase);
    	try
    	{
			DBAdder.addNewAccountQuery(account);
		}
    	catch (FileNotFoundException e)
    	{
			System.out.print("Error: Account could not be created. Please check database status");
		}
    	catch (IOException e)
    	{
			System.out.print("Error: Account could not be created. Please check database status");
		}
    	catch (SQLException e)
    	{
			System.out.print("Error: Account could not be created. Please check inputs or database status");
		}*/

		
    	Account customerAccount = new Account();
    	int newAccountID = 0;
    	
    	customerAccount.setFirstName(firstName);
    	customerAccount.setLastName(lastName);
    	customerAccount.setPhoneNumber(phoneNumber);
    	customerAccount.setEmail(email);
    	customerAccount.setProvince(province);
    	customerAccount.setCity(city);
    	customerAccount.setPostalCode(postalCode);
    	customerAccount.setCountry(country);
    	customerAccount.setStreetName(streetName);
    	customerAccount.setApartmentNumber(apartmentNumber);
    	customerAccount.setStreetNumber(streetNumber);
    	customerAccount.setAccountType(accountType);
    	customerAccount.setStatus(status);
    	customerAccount.setPassword(password);
    	customerAccount.setPassPhrase(passPhrase);
    	customerAccount.setBalanceOwed(0);
    	
    	try {
    		
    		newAccountID = DBAdder.addNewAccountQuery(customerAccount);
    		
    		//customerAccount = DBReader.getAccountQuery(newAccountID);
    		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return newAccountID;
    }
	
	/** The login method will allow a user to log in to the system
	 * 
	 * @param AccountID The ID of the user
	 * @param password The password of the user after hashing
	 * @return true if the user has entered the parameters correctly and they match the database entry
	 * @return false if either the ID does not match or the password does not match
	 * @precondition  AccountID must be an integer and password must be a String
	 * @postcondition returns true or false depending on input
	 */
	public boolean login(int accountID, String password)
	{
		/*
		Account account = null;
		try
		{
			account = DBReader.loginQuery(Email, password);
		}
		catch (FileNotFoundException e) {
			System.out.print("Error: Could not log in. Please try again later");
		}
		catch (IOException e) 
		{
			System.out.print("Error: Could not log in. Please try again later");
		} 
		catch (SQLException e) 
		{
			System.out.print("Error: Could not log in. Wrong email or password");
		}
		finally
		{
			if(account.getEmail().equals(Email))
			{
				if(account.getPassword().equals(password))
				{
					return true;
				}
			}
		}
		*/
		return false;
	}
	
	/**
	 * Logs the user off the system
	 */
	public void logout()
	{
		//TODO: logout
	}
	
	/** Allows the user to change the current password of their account
	 * 
	 * @param userAccount The Account object of the user
	 * @param oldPassword The current password of the user
	 * @param newPassword The new password of the user
	 * @param confirmPassword The confirmation of the new password
	 * @precondition userAccount must exist and passwords must be String types
	 * @postcondition Password will be updated
	 */
	public void setPassword(Account userAccount, String oldPassword, String newPassword, String confirmPassword)
	{
		/*
		if(userAccount.getPassword().equals(oldPassword))
		{
			if(newPassword.equals(confirmPassword))
			{
				userAccount.setPassword(newPassword);
			}
		}
		
		try
		{
			DBWriter.setAccountQuery(userAccount);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("Error: Could not change password.");
		} 
		catch (IOException e) 
		{
			System.out.print("Error: Could not change password.");
		}
		catch (SQLException e)
		{
			System.out.println("Error: Could not change password.");
		}
		*/

	}
	
	/** Allows the user to see their current balance
	 * 
	 * @param customerAccount The Account of the customer
	 * @return the user's current balance of fees
	 * @precondition The user account must exist
	 * @postcondition The balance is returned in double type
	 */
	public double getAccountBalance(Account customerAccount)
	{
		return customerAccount.getBalanceOwed();
	}
	
	/** Allows the user to view their current rentals in a list form
	 * 
	 * @param customerAccount The Account of the customer
	 * @return a list of rentals in the list type object
	 * @precondition The Account object must exist
	 * @postcondition The List of Rental objects is returned to the caller
	 */
	@WebMethod(operationName="getAccountRentals") 
	public String getAccountRentals(int accountID)
	{
		
		List<Rental> rentals = new ArrayList<Rental>();
		String accountRentals = "";
		
		try
		{
			rentals = DBReader.getAccountRentalsQuery(accountID);
		}
		catch (FileNotFoundException e)
		{
			//System.out.print("Error: Could not access database. Check connection.");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			//System.out.print("Error: Could not access database. Check connection");
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			//System.out.println("Error: Could not get a list of rentals. Check inputs.");
			e.printStackTrace();
		}
		
		for(int i = 0; i < rentals.size(); i++){
			
			accountRentals += rentals.get(i).rentalToJSONString() + "\n";
		}
		
		return accountRentals;
	}
	
	/** Returns account information
	 * 
	 * @param account_ID The account ID of the customer
	 * @return The customer account information
	 * @precondition The Account object must exist
	 * @postcondition A formatted string is returned to the caller
	 */
	public static Account getAccountInformation(int account_ID)
	{
		Account customerAccount = new Account();
		try {
			
			customerAccount = DBReader.getAccountQuery(account_ID);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerAccount;
	}
	
	/** A subaccount is added to the main user's account
	 * 
	 * @param customerAccount The customer's main account
	 * @precondition The customer's account object must exist
	 * @postcondition The subaccount is created
	 */
	public void addSubAccount(Account customerAccount)
	{
		/*
		SubAccount temp = new SubAccount(subAccountNumber, DOB, firstName, lastName, active, customerAccount);
		try
		{
			DBAdder.addNewSubAccountQuery(temp);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("Error: Could not create subaccount.");
		}
		catch (IOException e)
		{
			System.out.print("Error: Could not create subaccount.");
		}
		catch (SQLException e)
		{
			System.out.print("Error: Could not create subaccount.");
		}
		*/

	}
	
	/** Retrieves SubAccount information for the customer to view
	 * 
	 * @param customerAccount The account of the customer
	 * @return A formatted String that lists the information of the SubAccount
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static SubAccount getSubAccountInformation(int subAccountID)
	{
		SubAccount subAccount = new SubAccount();
		
		try {
			
			subAccount = DBReader.getSubAccountQuery(subAccountID);			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subAccount;
	}
	
	/** Retrieves a list of the customer's reservations
	 * 
	 * @param customerAccount The customer's account
	 * @return A list of reservation objects to be processed
	 * @precondition The customer account object must exist
	 * @postcondition The list is returned to the caller
	 */
	public String getAccountReservations(int accountID)
	{
		List<Reservation> reservations = new ArrayList<Reservation>();
		String accountReservations = "";
		
		try
		{
			reservations = DBReader.getAccountReservationsQuery(accountID);
		}
		catch (FileNotFoundException e)
		{
			//System.out.print("Error: Could not access database. Check connection.");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			//System.out.print("Error: Could not access database. Check connection");
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			//System.out.println("Error: Could not get a list of rentals. Check inputs.");
			e.printStackTrace();
		}
		
		for(int i = 0; i < reservations.size(); i++){
			
			accountReservations += reservations.get(i).reservationToJSONString() + "\n";
		}
		
		return accountReservations;
	}
}

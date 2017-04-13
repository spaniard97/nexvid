package com.nexvid.accounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.database_interface.DBReader;

/**
 * The AccountSearcher class is used to search for accounts that already
 * exist in the database. It is contacted by the AccountManager class
 * @author Brian Chan
 * @since 03/18/2017
 * @version 1.0.0.2
 *
 */
public class AccountSearcher
{
	/**
	 * The default constructor of the AccountSearcher
	 */
	public AccountSearcher()
	{
		
	}
	
	/**Allows the AccountSearcher class to search for an account using the ID number
	 * 
	 * @param AccountID The ID number of the account
	 * @return The customer's account
	 * @precondition The customer ID must be an integer
	 * @postcondition returns the Account object
	 */
	public Account searchByID(int AccountID)
	{
		Account temp = null;
		try
		{
			temp = DBReader.getAccountQuery(AccountID);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("Error: Please check your input");
		}
		catch (SQLException e)
		{
			System.out.print("Error: Please check your input");
		}
		catch (IOException e)
		{
			System.out.print("Error: Please check your input");
		}
		return temp;
	}
}

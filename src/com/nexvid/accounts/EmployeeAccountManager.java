package com.nexvid.accounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.database_interface.DBWriter;

/**The EmployeeAccountManager manages Employee Accounts
 *  * 
 * @author Brian Chan
 * @since 04/01/2017
 * @version 1.0.1.2
 *
 */
public class EmployeeAccountManager extends AccountManager
{
/*
    // Guarantees that class can only be instantiated once
    protected static EmployeeAccountManager instance;

    protected EmployeeAccountManager()
    {
    }

    // static block initialization for exception handling
    static
    {
	try
	{
	    instance = new EmployeeAccountManager();
	} catch (Exception e)
	{
	    throw new RuntimeException("Exception occured in creating singleton instance");
	}
    }

    public static EmployeeAccountManager getInstance(){
        if(instance== null)
    	{
    		try
    		{
    		    instance = new EmployeeAccountManager();
    		} catch (Exception e)
    		{
    		    throw new RuntimeException("Exception occured in creating singleton instance");
    		}
    	}

        return instance;
    }
    // end singleton guarantee
*/
    
    /**
     * The employee's method for creating new accounts, with only the required information.
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
     * @return The customer's account object
     * @precondition The account must not exist
     * @postcondition the account has been added
     */
    public Account addCustomer(Account account)
    {
    	return account;
    }
    
    /**
     * The employee's method for deactivating accounts
     * @param account the account to deactivate
     * @return true If the deactivation is successful
     * @return false If the deactivation fails
     * @precondition the account exists
     * @postcondition the account was deactivated
     */
    public boolean deactivateCustomerAccount(Account account)
    {
    	/*
    	account.setStatus("Deactivated");
    	if(account.getStatus().equals("Deactivated"))
    	{
    		try
    		{
				DBWriter.setAccountQuery(account);
			}
    		catch (FileNotFoundException e)
    		{
				System.out.print("Error: Could not deactivate account");
			}
    		catch (IOException e)
    		{
    			System.out.print("Error: Could not deactivate account");
			}
    		catch (SQLException e)
    		{
    			System.out.print("Error: Could not deactivate account");
			}
    		return true;
    	}
    	else
    	{
    		return false;
    	}
		*/
    	
    	return false;
    }
    
    /**
     * The employee's method for suspending customer accounts
     * @param account the account to suspend
     * @return the status of the account suspension
     * @precondition the account exists
     * @postcondition the account has been suspended
     */
    public Account suspendAccount(Account account)
    {
    	/*
    	account.setStatus("Suspended");
    	if(account.getStatus().equals("Suspended"))
    	{
    		try
    		{
				DBWriter.setAccountQuery(account);
			}
    		catch (FileNotFoundException e)
    		{
				System.out.print("Error: Could not suspend account");
			}
    		catch (IOException e)
    		{
    			System.out.print("Error: Could not suspend account");
			}
    		catch (SQLException e)
    		{
    			System.out.print("Error: Could not suspend account");
			}
    		return account;
    	}
    	else
    	{
    		return account;
    	}
    	*/

    	return account;
    }
    
    /**
     * The employee's method for increasing an account's fine
     * @param fine the fine to add to the account's current  balance
     * @param account the account to add the fine to
     * @return the status of the fine addition
     * @precondition the account exists, the fine is a positive amount
     * @postcondition the fine has been added to the account
     */
    public Account addFine(double fine, Account account) 
    {
    	/*
    	account.setBalanceOwed(account.getBalanceOwed() + fine);
    	try
		{
			DBWriter.setAccountQuery(account);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("Error: Could not add fine");
		}
		catch (IOException e)
		{
			System.out.print("Error: Could not add fine");
		}
		catch (SQLException e)
		{
			System.out.print("Error: Could not add fine");
		}
		return account;
		*/
    	return account;
    }
    
    /**
     * The employee's method for reducing an account's fine
     * @param fine the fine to reduce from the account's current balance
     * @param account the account to add the fine to
     * @return the status of the fine reduction
     * @precondition the account exists
     * @postcondition the fine has been reduced
     */
    public Account reduceFine(double fine, Account account)
    {
    	/*
    	if(fine >= account.getBalanceOwed())
    	{
    		account.setBalanceOwed(0);
    	}
    	account.setBalanceOwed(account.getBalanceOwed() - fine);
       	try
		{
			DBWriter.setAccountQuery(account);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("Error: Could not add fine");
		}
		catch (IOException e)
		{
			System.out.print("Error: Could not add fine");
		}
		catch (SQLException e)
		{
			System.out.print("Error: Could not add fine");
		}
		*/
    	
    	return account;
    }


}

package com.nexvid.accounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.nexvid.database_interface.DBAdder;
import com.nexvid.database_interface.DBWriter;

/**The SysAdminAccountManager manages the accounts of type System Administrator
 * 
 * @author Brian Chan
 * @since 04/01/2017
 * @version 1.0.0.2
 *
 */
public class SysAdminAccountManager extends ManagerAccountManager{

	/**
     * The system administrator's method for adding managers
     * @param manager the manager account to add
     * @return the status of the account addition
     * @postcondition the manager account has been added
     */
    public Account addManager(int accountID, String firstName, String lastName, String phoneNumber, String province,
			String city, String postalCode, String country, String streetName, int streetNumber, 
			String accountType, String status, String password)
    {
    	Account manager = super.addEmployee(accountID, firstName, lastName, phoneNumber, province, city, postalCode, 
    			country, streetName, streetNumber, "Manager", status, password);
    	try
    	{
			DBAdder.addNewAccountQuery(manager);
		}
    	catch (FileNotFoundException e)
    	{
			System.out.print("Error: Could not add Manager Account");
		}
    	catch (IOException e)
    	{
    		System.out.print("Error: Could not add Manager Account");
		}
    	catch (SQLException e) {
    		System.out.print("Error: Could not add Manager Account");
		}
    	return manager;
    }
    
    /**
     * The system administrator's method for deactivating manager accounts
     * @param manager the manager account to deactivate
     * @return the status of the account deactivation
     * @precondition the manager account exists
     * @postcondition the manager account has been deactivated
     */
    public boolean deactivateManager(Account manager)
    {
    	manager.setStatus("Deactivated");
    	if(manager.getStatus().equals("Deactivated"))
    	{
    		try
    		{
				DBWriter.setAccountQuery(manager);
			}
    		catch (FileNotFoundException e)
    		{
				System.out.print("Error occured while setting status");
			}
    		catch (IOException e)
    		{
    			System.out.print("Error occured while setting status");
			}
    		catch (SQLException e)
    		{
    			System.out.print("Error occured while setting status");
			}
    		return true;
    	}
    	else
    	{
    	return false;
    	}
    }
}

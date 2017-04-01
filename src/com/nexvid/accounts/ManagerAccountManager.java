package com.nexvid.accounts;

/** The ManagerAccountManager manages Manager Accounts
 * 
 * @author Brian Chan
 * @since 01/04/2017
 * @version 1.0.0.2
 *
 */
public class ManagerAccountManager extends EmployeeAccountManager {

	/**
     * The manager's method for adding a new employee
     * @param employee the new employee
     * @return the status of the account employee addition 
     * @postcondition the account has been added
     */
    public Account addEmployee(int accountID, String firstName, String lastName, String phoneNumber, String province,
			String city, String postalCode, String country, String streetName, int streetNumber, 
			String accountType, String status, String password)
    {
		return new Account(accountID,firstName,lastName,phoneNumber,province,
				city,postalCode,country,streetName,streetNumber,accountType,status,password);
    }
    
    /**
     * The manager's method for deactivating employees
     * @param employee the employee account to deactivate
     * @return the status of the account deactivation
     * @precondition the employee account exists
     * @postcondition the employee account has been deactivated
     */
    public boolean deactivateEmployee(Account employee)
    {
    	employee.setStatus("Deactivated");
    	return true;
    }
    
}

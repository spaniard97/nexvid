package com.nexvid.accounts;

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
	return null;
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
	return false;
    }
    
}

package com.nexvid.accounts;

public class EmployeeAccountManager
{
/*
    // Guarantees that class can only be instantiated once
    private static EmployeeAccountManager instance;

    private EmployeeAccountManager()
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
        return instance;
    }
    // end singleton guarantee
*/
    
    /**
     * The employee's method for creating new accounts
     * @param account the account to add
     * @return the status of the account activation
     * @postcondition the account has been added
     * 
     * @POST
     * @PATH("/addCustomer")
     * @consumes(MediaType.Application_JSON)
     */
    public static boolean addCustomer(CustomerAccount newAccount)
    {
	return true;
    }
    
    /**
     * The employee's method for deactivating customer accounts
     * @param account the account to deactivate
     * @return the status of the account deactivation
     * @precondition the account exists
     * @postcondition the account was deactivated
     * 
     * @POST
     * @Path("/deactivateAccount")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public static boolean deactivateAccount(CustomerAccount account)
    {
	return true;
    }
    
    /**
     * The employee's method for suspending customer accounts
     * @param account the account to suspend
     * @return the boolean status of the account suspension
     */
    public static boolean suspendAccount(CustomerAccount account)
    {
	return true;
    }
    
    /**
     * The employee's method for increasing an account's fine
     * @param fine the fine to add to the account's current  balance
     * @param account the account to add the fine to
     * @return the boolean status of the fine addition
     */
    public static boolean addFine(Fine fine, CustomerAccount account) 
    {
	return true;
    }
    
    /**
     * The employee's method for reducing an account's fine
     * @param fine the fine to reduce from the account's current balance
     * @param account the account to add the fine to
     * @return the boolean status of the fine reduction
     */
    public static boolean reduceFine(Fine fine, CustomerAccount account)
    {
	return true;
    }
    
    /**
     * The manager's method for adding a new employee
     * @param employee the new employee
     * @return the boolean status of the account employee addition 
     */
    public static boolean addEmployee(EmployeeAccount employee)
    {
	return true;
    }
    
    /**
     * The manager's method for deactivating employees
     * @param employee the employee account to deactivate
     * @return the boolean status of the account deactivation
     */
    public static boolean deactivateEmployee(EmployeeAccount employee)
    {
	return true;
    }
    
    /**
     * The system administrator's method for adding managers
     * @param manager the manager account to add
     * @return the boolean status of the account addition
     */
    public static boolean addManager(ManagerAccount manager)
    {
	return true;
    }
    
    /**
     * The system administrator's method for deactivating manager accounts
     * @param manager the manager account to deactivate
     * @return the boolean status of the account deactivation
     */
    public static boolean deactivateManager(ManagerAccount manager)
    {
	return true;
    }
}

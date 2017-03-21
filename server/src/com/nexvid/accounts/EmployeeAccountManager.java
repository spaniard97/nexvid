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
     * @produces(MediaType.Application_JSON)
     */
    public String addCustomer(CustomerAccount newAccount)
    {
	return "";
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
    public String deactivateAccount(CustomerAccount account)
    {
	return "";
    }
    
    /**
     * The employee's method for suspending customer accounts
     * @param account the account to suspend
     * @return the status of the account suspension
     * @precondition the account exists
     * @postcondition the account has been suspended
     * 
     * @POST
     * @Path("/suspendAccount")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String suspendAccount(CustomerAccount account)
    {
	return "";
    }
    
    /**
     * The employee's method for increasing an account's fine
     * @param fine the fine to add to the account's current  balance
     * @param account the account to add the fine to
     * @return the status of the fine addition
     * @precondition the account exists, the fine is a positive amount
     * @postcondition the fine has been added to the account
     * 
     * @POST
     * @Path("/addFine")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String addFine(Fine fine, CustomerAccount account) 
    {
	return "";
    }
    
    /**
     * The employee's method for reducing an account's fine
     * @param fine the fine to reduce from the account's current balance
     * @param account the account to add the fine to
     * @return the status of the fine reduction
     * @precondition the account exists
     * @postcondition the fine has been reduced
     * 
     * @POST
     * @Path("/reduceFine")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String reduceFine(Fine fine, CustomerAccount account)
    {
	return "";
    }
    
    /**
     * The manager's method for adding a new employee
     * @param employee the new employee
     * @return the status of the account employee addition 
     * @postcondition the account has been added
     * 
     * @POST
     * @Path("/addEmployee")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String addEmployee(EmployeeAccount employee)
    {
	return "";
    }
    
    /**
     * The manager's method for deactivating employees
     * @param employee the employee account to deactivate
     * @return the status of the account deactivation
     * @precondition the employee account exists
     * @postcondition the employee account has been deactivated
     * 
     * @POST
     * @Path("/deactivateEmployee")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String deactivateEmployee(EmployeeAccount employee)
    {
	return "";
    }
    
    /**
     * The system administrator's method for adding managers
     * @param manager the manager account to add
     * @return the status of the account addition
     * @postcondition the manager account has been added
     * 
     * @POST
     * @Path("/addManager")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String addManager(EmployeeAccount manager)
    {
	return "";
    }
    
    /**
     * The system administrator's method for deactivating manager accounts
     * @param manager the manager account to deactivate
     * @return the status of the account deactivation
     * @precondition the manager account exists
     * @postcondition the manager account has been deactivated
     * 
     * @POST
     * @Path("/deactivateManager")
     * @consumes(MediaType.Application_JSON)
     * @produces(MediaType.Application_JSON)
     */
    public String deactivateManager(EmployeeAccount manager)
    {
	return "";
    }


}

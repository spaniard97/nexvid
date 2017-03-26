package com.nexvid.accounts;

public class SysAdminAccountManager extends ManagerAccountManager{

	/**
     * The system administrator's method for adding managers
     * @param manager the manager account to add
     * @return the status of the account addition
     * @postcondition the manager account has been added
     */
    public Account addManager(Account manager)
    {
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
	return false;
    }
    
}

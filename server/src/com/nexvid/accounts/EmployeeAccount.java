package com.nexvid.accounts;

public class EmployeeAccount extends CustomerAccount
{
    private String role;

    public EmployeeAccount(String address, String phoneNumber, String email, Boolean confirmed, Balance balanceOwed,
            String passPhrase, String role)
    {
	super(address, phoneNumber, email, confirmed, balanceOwed, passPhrase);
	setRole(role);
    }
    
    private String getRole()
    {
	return this.role;
    }
    
    private void setRole(String aRole)
    {
	this.role = aRole;
    }
    
    
}

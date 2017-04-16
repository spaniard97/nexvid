package com.nexvid.accounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * The AccountSearcher class is used to search for accounts that already
 * exist in the database. It is contacted by the AccountManager class
 * @author Brian Chan
 * @since 03/18/2017
 * @version 1.0.0.2
 *
 */
@WebService (serviceName="AccountSearcher")
@SOAPBinding(style = Style.RPC)
public class AccountSearcher
{
	/**
	 * The default constructor of the AccountSearcher
	 */
	public AccountSearcher(){
		
	}
	
	/**Allows the AccountSearcher class to search for an account using the ID number
	 * 
	 * @param AccountID The ID number of the account
	 * @return The customer's account
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @precondition The customer ID must be an integer
	 * @postcondition returns the Account object
	 */
	@WebMethod(operationName="searchByID") 
	public String searchByID(@WebParam(name = "accountID") int accountID)
	{
		Account customerAccount = AccountManager.getAccountInformation(accountID);
		
		return customerAccount.AccountToJSONString();
	}
	
	/**Allows the AccountSearcher class to search for an account using the ID number
	 * 
	 * @param AccountID The ID number of the account
	 * @return The customer's account
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @precondition The customer ID must be an integer
	 * @postcondition returns the Account object
	 */
	@WebMethod(operationName="searchSubAccount") 
	public String searchSubAccount(@WebParam(name = "subAccountID") int subAccountID)
	{
		SubAccount subAccount = AccountManager.getSubAccountInformation(subAccountID);
		
		return subAccount.SubAccountToJSONString();
	}
	
}

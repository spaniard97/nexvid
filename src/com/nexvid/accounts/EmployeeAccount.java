package com.nexvid.accounts;

public class EmployeeAccount extends CustomerAccount {

	protected EmployeeAccount(String streetName, String appartmentNumber, int streetNumber, String city, String province,
			String country, String phoneNumber, String email, String passPhrase, String type) {
		super(streetName, appartmentNumber, streetNumber, city, province, country, phoneNumber, email, "Confirmed",
				passPhrase);
		this.setAccountType(type);
	}

}

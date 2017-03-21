package com.nexvid.accounts;

public class EmployeeAccount extends CustomerAccount {
	private String role;

	protected EmployeeAccount(String streetName, String appartmentNumber, int streetNumber, String city,
			String province, String country, String phoneNumber, String email, String passPhrase, String role) {
		super(streetName, appartmentNumber, streetNumber, city, province, country, phoneNumber, email, true,
				passPhrase);
		setRole(role);
	}

	protected String getRole() {
		return this.role;
	}

	protected void setRole(String aRole) {
		this.role = aRole;
	}

}

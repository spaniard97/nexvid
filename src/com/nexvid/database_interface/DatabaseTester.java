package com.nexvid.database_interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class DatabaseTester {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try {
			DBReader.getAccountQuery(100000004);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

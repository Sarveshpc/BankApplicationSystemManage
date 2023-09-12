package com.schoolapplication.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {

	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Sarvesh@1234");
	}
}
		
		


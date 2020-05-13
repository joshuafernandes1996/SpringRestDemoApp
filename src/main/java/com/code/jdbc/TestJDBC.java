package com.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String user = "springstudent";
		String password  = "springstudent";
		
		try {
			System.out.println("Connection to: " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL , user, password);
			System.out.println("Connection Successful. " + myConn);
			
		}
		catch(Exception err) {
			err.printStackTrace();
		}
	}

}

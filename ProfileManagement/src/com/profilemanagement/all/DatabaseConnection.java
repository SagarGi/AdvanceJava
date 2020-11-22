package com.profilemanagement.all;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection implements DataUtil {
	static Connection con = null;
	
	public static  Connection  getCon()
	{
		try {
			Class.forName(dbdriver); // loading driver
			
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Database Connection Successfull!!!");
			
			
		} catch (Exception e) {
			System.out.println("Connection failed");
		}
		
		return con;
//		returns whether the connection is successfully established or not !!
	}
}

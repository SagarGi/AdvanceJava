package com.sagar.login.databse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sagar.login.bean.*;

public class LoginDao {
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException
	{
		boolean status = false;
		
//		connection to the database first
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from logintable where username = ? and password = ? "))
		{
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
}

package com.profilemanagement.all;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
	
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertUser(UserPojo user) {
		int status = 0;
		
		try {
			
			con = DatabaseConnection.getCon();
			ps = con.prepareStatement("insert into userdb values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4,user.getLastname());
			ps.setString(5,user.getCity());
			ps.setString(6,user.getCountry());
			ps.setString(7,user.getPhone());
			ps.setString(8,user.getEducation());
			ps.setString(9,user.getProfession());
			ps.setString(10,user.getGender());
			
			status = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("Registration Failed!!");
		}
		return status;
	}

	@Override
	public UserPojo getUser(String email, String password) {
		UserPojo user = new UserPojo();
		try {
			con = DatabaseConnection.getCon();
			ps = con.prepareStatement("select * from userdb where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				user.setEmail(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
			
			
		} catch (Exception e) {
			System.out.println("user not found");
		}
		return user;
	}

}

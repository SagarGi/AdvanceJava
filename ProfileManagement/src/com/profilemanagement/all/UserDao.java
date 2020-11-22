package com.profilemanagement.all;

public interface UserDao {
	public int  insertUser(UserPojo user);
	public UserPojo getUser(String email, String password);
}

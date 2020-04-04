package com.svyatobatko.dimploma.dao;

import com.svyatobatko.dimploma.models.UserData;

public interface UserDao {
	UserData getUserById(int i);
	UserData getUserByLogin(String Login);
	void addUser(UserData user);
}

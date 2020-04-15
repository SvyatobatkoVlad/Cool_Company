package com.svyatobatko.dimploma.dao;


import java.util.List;

import com.svyatobatko.dimploma.models.TourData;
import com.svyatobatko.dimploma.models.UserData;

public interface UserDao {
	UserData getUserById(int i);

	UserData getUserByLogin(String Login);

	void addUser(UserData user);

	List<UserData> getAllUsers();
	
	void updateUser(UserData user);


}

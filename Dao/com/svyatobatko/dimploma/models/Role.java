package com.svyatobatko.dimploma.models;

import com.svyatobatko.dimploma.models.Role;

public enum Role {
	ADMIN, CLIENT, CONTENT_MANAGER;
	
	public static int getRoleIndex(Role role) {
		return role.ordinal();
}

	public static Role getRoleById(int roleID) {

		switch (roleID) {
		case 1:
			return Role.ADMIN;
		case 2:
			return Role.CLIENT;
		case 3:
			return Role.CONTENT_MANAGER;
		}
		return null;

	}
}
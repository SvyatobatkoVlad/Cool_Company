package com.svyatobatko.dimploma.models;

import com.svyatobatko.dimploma.models.Cities;

public enum Cities {
	Kharkiv, Milan, Paris;
	
	public static int getCitiesIndex(Cities cities) {
		return cities.ordinal();
}

	public static Cities getCitiesById(int ID_Cities) {

		switch (ID_Cities) {
		case 1:
			return Cities.Kharkiv;
		case 2:
			return Cities.Milan;
		case 3:
			return Cities.Paris;
		}
		return null;

	}
}
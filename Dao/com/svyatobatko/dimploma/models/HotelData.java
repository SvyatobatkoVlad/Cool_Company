package com.svyatobatko.dimploma.models;

import com.svyatobatko.dimploma.models.Cities;

public class HotelData {
	private int id;
	private String Hotels_name;
	private int Stars;
	private Cities cities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStars() {
		return Stars;
	}

	public void setStars(int stars) {
		Stars = stars;
	}

	public String getHotels_name() {
		return Hotels_name;
	}

	public void setHotels_name(String hotels_name) {
		Hotels_name = hotels_name;
	}

	public Cities getCities() {
		return cities;
	}

	public void setCities(Cities cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "HotelData [id=" + id + ", Hotels_name=" + Hotels_name + ", Stars=" + Stars + ", cities=" + cities + "]";
	}

	
	
}

package com.svyatobatko.dimploma.models;

public class UserTourData {

	private int idTour;
	private String nameUser;
	public int getId() {
		return idTour;
	}
	public void setId(int id) {
		this.idTour = id;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	
	@Override
	public String toString() {
		return "UserTourData [idTour=" + idTour + ", nameUser=" + nameUser + "]";
	}
	
	
	
}

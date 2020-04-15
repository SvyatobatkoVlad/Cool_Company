package com.svyatobatko.dimploma.models;

public class OrdersData {
	private int id;
	private String Datas;
	private double price;
	private int ID_user;
	private int ID_tour;

	public String getDatas() {
		return Datas;
	}

	public void setDatas(String datas) {
		Datas = datas;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getID_user() {
		return ID_user;
	}

	public void setID_user(int iD_user) {
		ID_user = iD_user;
	}

	public int getID_tour() {
		return ID_tour;
	}

	public void setID_tour(int iD_tour) {
		ID_tour = iD_tour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrdersData [id=" + id + ", Datas=" + Datas + ", price=" + price + ", ID_user=" + ID_user + ", ID_tour="
				+ ID_tour + "]";
	}

}

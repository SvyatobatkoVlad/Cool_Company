package com.svyatobatko.dimploma.models;

import com.svyatobatko.dimploma.models.Type;

public class TourData {
	private int id;
	private String startData;
	private String endData;
	private Type type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartData() {
		return startData;
	}
	public void setStartData(String startData) {
		this.startData = startData;
	}
	public String getEndData() {
		return endData;
	}
	public void setEndData(String endData) {
		this.endData = endData;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "TourData [id=" + id + ", startData=" + startData + ", endData=" + endData + ", type=" + type + "]";
	}
	

}

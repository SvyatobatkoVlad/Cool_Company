package com.svyatobatko.dimploma.dao;

import com.svyatobatko.dimploma.models.TourData;
import com.svyatobatko.dimploma.models.UserData;

import java.util.List;

public interface TourDao {
	TourData getTourById(int i);
	
	List<TourData> getToursForUser(UserData user);
	
	List<TourData> getAllTour();
	
	
}

package com.svyatobatko.dimploma.demo;

import java.util.List;
import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dao.impl.DefaultUserDao;
import com.svyatobatko.dimploma.models.UserData;
import com.svyatobatko.dimploma.dao.HotelDao;
import com.svyatobatko.dimploma.dao.impl.DefaultHotelDao;
import com.svyatobatko.dimploma.models.HotelData;
import com.svyatobatko.dimploma.dao.TourDao;
import com.svyatobatko.dimploma.dao.impl.DefaultTourDao;
import com.svyatobatko.dimploma.models.TourData;
import com.svyatobatko.dimploma.dao.OrdersDao;
import com.svyatobatko.dimploma.dao.impl.DefaultOrdersDao;
import com.svyatobatko.dimploma.models.OrdersData;

public class Demo {
	
	public static void main(String[] args) {
		
		UserDao userDao = DefaultUserDao.getInstance();
		UserData user = userDao.getUserByLogin("Svyatobatko@gmail.com");
		System.out.println(user);
		/*
		 * UserDao userDao = DefaultUserDao.getInstance(); UserData user =
		 * userDao.getUserById(2); System.out.println(user);
		 */
	
		
		/*
		UserData user = new UserData();
		System.out.println();
		
		 userDao.addUser(user);
		 */
		/*
		UserDao userDao = DefaultUserDao.getInstance();
		UserData user = userDao.getUserByLogin("Svyatobatko@gmail.com");
		System.out.println(user);

		System.out.println();

		HotelDao hotelDao = DefaultHotelDao.getInstance();
		HotelData hotel = hotelDao.getHotelById(2);
		System.out.println(hotel);

		System.out.println();

		TourDao tourDao = DefaultTourDao.getInstance();
		TourData tour = tourDao.getTourById(2);
		System.out.println(tour);

		System.out.println();

		OrdersDao ordersDao = DefaultOrdersDao.getInstance();
		OrdersData orders = ordersDao.getOrdersById(2);
		System.out.println(orders);
		

		
		System.out.println("-------------------------------------------");
		
		List<UserData> listUsers = userDao.getAllUsers();
		System.out.println(listUsers);
		*/
		
		/*
		TourDao tour = DefaultTourDao.getInstance();
		List<TourData> listUsers = tour.getToursForUser(user);
		System.out.println(listUsers);
		*/
	}
}
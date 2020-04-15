package com.svyatobatko.dimploma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.svyatobatko.dimploma.dao.HotelDao;
import com.svyatobatko.dimploma.dbutils.DataSourceUtils;
import com.svyatobatko.dimploma.models.HotelData;
import com.svyatobatko.dimploma.models.Cities;

public class DefaultHotelDao implements HotelDao {

	private static final String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE ID_Hotels = ?";
	private static DefaultHotelDao instance;
	private DataSource ds;

	private DefaultHotelDao() {
	}

	{
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultHotelDao getInstance() {
		if (instance == null) {
			instance = new DefaultHotelDao();
		}
		return instance;
	}

	@Override
	public HotelData getHotelById(int id) {
		HotelData hotel = null;
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_HOTEL_BY_ID)) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					hotel = new HotelData();
					hotel.setHotels_name(rs.getString("Hotels_name"));
					hotel.setStars(rs.getInt("Stars"));
					hotel.setId(rs.getInt("ID_Hotels"));
					hotel.setCities(Cities.getCitiesById(rs.getInt("ID_Cities"))); 
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotel;
	}
}

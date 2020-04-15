package com.svyatobatko.dimploma.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.svyatobatko.dimploma.dao.TourDao;
import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dbutils.DataSourceUtils;
import com.svyatobatko.dimploma.models.Type;
import com.svyatobatko.dimploma.models.UserData;
import com.svyatobatko.dimploma.models.Role;
import com.svyatobatko.dimploma.models.TourData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DefaultTourDao implements TourDao {

	private static final String SELECT_TOUR_BY_ID = "SELECT * FROM tour WHERE ID_tour = ?";
	public static final String GET_TOURS_FOR_USER = "SELECT Orders.ID_tour from Orders inner JOIN User on User.ID_user = ?;";
	private static final String SELECT_ALL_TOUR = "SELECT * FROM tour;";		
    private static DefaultTourDao instance;
	private DataSource ds;

	private DefaultTourDao() {
	}

	{
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultTourDao getInstance() {
		if (instance == null) {
			instance = new DefaultTourDao();
		}
		return instance;
	}

	@Override
	public TourData getTourById(int id) {
		TourData tour = null;
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_TOUR_BY_ID)) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					tour = new TourData();
					tour.setStartData(rs.getString("start_data"));
					tour.setEndData(rs.getString("End_date"));
					tour.setId(rs.getInt("ID_tour"));
					tour.setType(Type.getTypeById(rs.getInt("ID_Type_of_tour")));
					tour.setTourName(rs.getString("TourName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tour;
	}

	
	@Override
	public List<TourData> getToursForUser(UserData user) {
		try (Connection conn = ds.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(GET_TOURS_FOR_USER)) {
			ps.setString(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				return Collections.emptyList();
			} else {
				List<TourData> tours = new ArrayList<>();
				do {
					TourData tourData = new TourData();
					tourData.setId(rs.getInt("id"));
					tours.add(tourData);
				} while (rs.next());
				return tours;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public List<TourData> getAllTour() {
		TourData tour = null;
		List<TourData> toursList = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				Statement ps = conn.createStatement()) {
			
			try (ResultSet rs = ps.executeQuery(SELECT_ALL_TOUR);) {
				while (rs.next()) {
					tour = new TourData();
					tour.setStartData(rs.getString("start_data"));
					tour.setEndData(rs.getString("End_date"));
					tour.setId(rs.getInt("ID_tour"));
					tour.setType(Type.getTypeById(rs.getInt("ID_Type_of_tour")));
					tour.setTourName(rs.getString("TourName"));
					toursList.add(tour);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toursList;

	}
	
	
	
	
	
}

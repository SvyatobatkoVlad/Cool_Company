package com.svyatobatko.dimploma.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.svyatobatko.dimploma.dao.TourDao;
import com.svyatobatko.dimploma.dbutils.DataSourceUtils;
import com.svyatobatko.dimploma.models.Type;
import com.svyatobatko.dimploma.models.TourData;

public class DefaultTourDao implements TourDao  {

	private static final String SELECT_TOUR_BY_ID = "SELECT * FROM tour WHERE ID_tour = ?";
	/*
	private static final String URL = "jdbc:mysql://localhost:3306/cool_company?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
*/
	
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
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_TOUR_BY_ID)) {
			
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					tour = new TourData();
					tour.setStartData(rs.getString("start_data"));
					tour.setEndData(rs.getString("End_date"));
					tour.setId(rs.getInt("ID_tour"));
					tour.setType(Type.getTypeById(rs.getInt("ID_Type_of_tour")));
					//user.setRole(Role.getRoleById(rs.getInt("ID_role")));
					//tour.setLogin(rs.getString("Login"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tour;
	}
	
	/*
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	*/
}

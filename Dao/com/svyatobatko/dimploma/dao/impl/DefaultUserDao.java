package com.svyatobatko.dimploma.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dbutils.DataSourceUtils;
import com.svyatobatko.dimploma.models.Role;
import com.svyatobatko.dimploma.models.UserData;


public class DefaultUserDao implements UserDao {
	
	
	private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE Login = ?";
	
	private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE ID_user = ?";
	private static final String ADD_USER = "INSERT INTO users (first_name, last_name, date_of_birth, login, password, telephone) " + "VALUES (?,?,?,?,?,?)";

	/*
	private static final String URL = "jdbc:mysql://localhost:3306/cool_company?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
*/
	private static DefaultUserDao instance;
	private DataSource ds;
	
	private DefaultUserDao() {
	}
	
	{
		this.ds = DataSourceUtils.getDataSource();
	}
	
	
	public static synchronized DefaultUserDao getInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	
	@Override
	public UserData getUserById(int id) {
		UserData user = new UserData();
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
			
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("FirstName"));
					user.setLastName(rs.getString("LastName"));
					user.setId(rs.getInt("ID_user"));
					user.setLogin(rs.getString("Login"));
					user.setPassword(rs.getString("Password"));
					user.setTelephone(rs.getString("Telephone"));
					user.setDateOfBirth(rs.getString("Date_of_Birth"));
					user.setRole(Role.getRoleById(rs.getInt("ID_role")));
					
				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	/*
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}*/
	
	@Override
	public UserData getUserByLogin(String login) {
		UserData user = null;
		try (Connection conn = ds.getConnection()) {
			PreparedStatement pStatmenet = conn.prepareStatement(SELECT_USER_BY_LOGIN);
			pStatmenet.setString(1, login);
			ResultSet rs = pStatmenet.executeQuery();
			if (rs.next()) {
				user = new UserData();
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setId(rs.getInt("ID_user"));
				user.setLogin(rs.getString("Login"));
				user.setPassword(rs.getString("Password"));
				user.setTelephone(rs.getString("Telephone"));
				user.setDateOfBirth(rs.getString("Date_of_Birth"));
				user.setRole(Role.getRoleById(rs.getInt("ID_role")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public void addUser(UserData user) {
	    try(Connection conn = ds.getConnection();
	        PreparedStatement ps = conn.prepareStatement(ADD_USER);) {
	        ps.setString(1, user.getFirstName());
	        ps.setString(2, user.getLastName());
	        ps.setString(3, user.getDateOfBirth());
	        ps.setString(4, user.getLogin());
	        ps.setString(5, user.getPassword());
	        ps.setString(6, user.getTelephone());
	       // ps.setInt(7, Role.getRoleIndex(Role.CLIENT));
	        ps.execute();

	      }catch (SQLException e) {
	        e.printStackTrace();
	      } 
	      
	    }
	
	
	
}











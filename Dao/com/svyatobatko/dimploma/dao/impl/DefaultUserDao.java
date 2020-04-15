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


import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dbutils.DataSourceUtils;
import com.svyatobatko.dimploma.models.Role;
import com.svyatobatko.dimploma.models.UserData;

public class DefaultUserDao implements UserDao {

	private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE Login = ?";

	private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE ID_user = ?";
	private static final String ADD_USER = "INSERT INTO user (LastName, FirstName , Date_of_birth, Login, Password, Telephone) "
			+ "VALUES (?,?,?,?,?,?)";

	private static final String SELECT_ALL_USERS = "SELECT * FROM user;";
	 private static final String UPDATE_USERS_SQL = "update user set LastName = ?,FirstName= ?, Date_of_birth =?, Telephone=? WHERE ID_user = ?;";

	private static DefaultUserDao instance;
	private DataSource ds;

	 DefaultUserDao() {
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
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("FirstName"));
					user.setLastName(rs.getString("LastName"));
					user.setId(rs.getString("ID_user"));
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
				user.setId(rs.getString("ID_user"));
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
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(ADD_USER);) {
			ps.setString(2, user.getLastName());
			ps.setString(1, user.getFirstName());
			ps.setString(3, user.getDateOfBirth());
			ps.setString(4, user.getLogin());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getTelephone());
			// ps.setInt(7, Role.getRoleIndex(Role.CLIENT));
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public List<UserData> getAllUsers() {
		UserData user = null;
		List<UserData> usersList = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				Statement ps = conn.createStatement()) {
			
			try (ResultSet rs = ps.executeQuery(SELECT_ALL_USERS);) {
				while (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("FirstName"));
					user.setLastName(rs.getString("LastName"));
					user.setId(rs.getString("ID_user"));
					user.setLogin(rs.getString("Login"));
					user.setPassword(rs.getString("Password"));
					user.setTelephone(rs.getString("Telephone"));
					user.setDateOfBirth(rs.getString("Date_of_Birth"));
					user.setRole(Role.getRoleById(rs.getInt("ID_role")));
					usersList.add(user);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
		
		public void updateUser(UserData user) {
			try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_USERS_SQL);) {
			ps.setString(1, user.getLastName());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getDateOfBirth());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	}
	
		
	
	
	


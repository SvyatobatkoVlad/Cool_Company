package com.svyatobatko.dimploma.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.svyatobatko.dimploma.dao.OrdersDao;
import com.svyatobatko.dimploma.dbutils.DataSourceUtils;
import com.svyatobatko.dimploma.models.OrdersData;

public class DefaultOrdersDao implements OrdersDao {

	private static final String SELECT_ORDERS_BY_ID = "SELECT * FROM orders WHERE ID_orders = ?";
	private static DefaultOrdersDao instance;
	private DataSource ds;

	private DefaultOrdersDao() {
	}

	{
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultOrdersDao getInstance() {
		if (instance == null) {
			instance = new DefaultOrdersDao();
		}
		return instance;
	}

	@Override
	public OrdersData getOrdersById(int id) {
		OrdersData orders = null;
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_ORDERS_BY_ID)) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					orders = new OrdersData();
					orders.setDatas(rs.getString("Datas"));
					orders.setPrice(rs.getDouble("price"));
					orders.setId(rs.getInt("ID_orders"));
					orders.setID_user(rs.getInt("ID_user"));
					orders.setID_tour(rs.getInt("ID_tour"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}

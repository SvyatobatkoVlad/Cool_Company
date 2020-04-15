package com.svyatobatko.dimploma.controller.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svyatobatko.dimploma.dao.OrdersDao;
import com.svyatobatko.dimploma.dao.impl.DefaultOrdersDao;
import com.svyatobatko.dimploma.models.OrdersData;

public class GetOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrdersDao ordersDao;

	{
		ordersDao = DefaultOrdersDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersData orders = ordersDao.getOrdersById(Integer.valueOf(request.getParameter("id")));
		response.getWriter().println(orders);

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

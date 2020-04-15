package com.svyatobatko;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svyatobatko.dimploma.dao.TourDao;
import com.svyatobatko.dimploma.dao.impl.DefaultTourDao;
import com.svyatobatko.dimploma.models.TourData;

public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDao tourDao;

	{
		tourDao = DefaultTourDao.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TourData> toursList = tourDao.getAllTour();
		request.setAttribute("toursList", toursList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tour-list.jsp");
		dispatcher.forward(request, response);
	}

}

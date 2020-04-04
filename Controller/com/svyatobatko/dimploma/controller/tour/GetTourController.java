package com.svyatobatko.dimploma.controller.tour;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.svyatobatko.dimploma.dao.TourDao;
import com.svyatobatko.dimploma.dao.impl.DefaultTourDao;
import com.svyatobatko.dimploma.models.TourData;

public class GetTourController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private TourDao tourDao;
	
	
	{
		tourDao = DefaultTourDao.getInstance();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TourData tour = tourDao.getTourById(Integer.valueOf(request.getParameter("id")));
		response.getWriter().println(tour);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

package com.svyatobatko.dimploma.controller.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dao.impl.DefaultUserDao;
import com.svyatobatko.dimploma.models.UserData;

public class GetUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserData user = userDao.getUserById(Integer.valueOf(request.getParameter("id")));
		response.getWriter().println(user);

		/*
		 * request.setAttribute("Login", user);
		 * request.getRequestDispatcher("WEB-INF/views/user.jsp") .forward(request,
		 * response);
		 */

	}

}

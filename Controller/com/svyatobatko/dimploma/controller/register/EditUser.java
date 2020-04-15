package com.svyatobatko.dimploma.controller.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dao.impl.DefaultUserDao;
import com.svyatobatko.dimploma.models.UserData;

public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/EditAccount.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserData user = new UserData();
		user.setLastName(request.getParameter("lastname"));
		user.setFirstName(request.getParameter("firstname"));
		user.setDateOfBirth(request.getParameter("Date_of_Birth"));
		user.setTelephone(request.getParameter("Telephone"));
		user.setId(request.getParameter("id"));
		userDao.updateUser(user);
		doGet(request, response);
	}

}

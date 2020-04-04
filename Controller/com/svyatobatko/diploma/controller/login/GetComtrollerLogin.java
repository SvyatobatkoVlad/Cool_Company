package com.svyatobatko.diploma.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

import com.svyatobatko.dimploma.dao.UserDao;
import com.svyatobatko.dimploma.dao.impl.DefaultUserDao;
import com.svyatobatko.dimploma.models.Role;
import com.svyatobatko.dimploma.models.UserData;

public class GetComtrollerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGGED_IN_USER_ATTRIBUTE = "loggedInUser";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute(LOGGED_IN_USER_ATTRIBUTE) != null) {
			UserData user = (UserData) session.getAttribute(LOGGED_IN_USER_ATTRIBUTE);
			redirectUserByRole(response, user);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	private void redirectUserByRole(HttpServletResponse response, UserData user) throws IOException {
		if (user.getRole() == Role.ADMIN) {
			response.sendRedirect(getServletContext().getContextPath() + "/admin");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/Client");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao userDao = DefaultUserDao.getInstance();
		UserData user = null;
		String login = request.getParameter("Login");
		String password = request.getParameter("Password");

		user = userDao.getUserByLogin(login);

		if (login.isEmpty() || password.isEmpty()) {
			request.setAttribute("message", "Поля не могут быть пустыми");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else if (user == null) {
			request.setAttribute("message", "Пользователь не существует");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else if (!user.getPassword().equals(password)) {
			request.setAttribute("message", "Неправильный пароль");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			/*
			 * } else if (user.getRole()==Role.CLIENT) { request.setAttribute("user", user);
			 * request.getRequestDispatcher("Client.jsp").forward(request, response);
			 * 
			 * }else if (user.getRole()==Role.ADMIN) { request.setAttribute("user", user);
			 * request.getRequestDispatcher("Admin.jsp").forward(request, response);
			 */
		} else if (user.getPassword() != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute(LOGGED_IN_USER_ATTRIBUTE, user);
			redirectUserByRole(response, user);
		}

	}
}

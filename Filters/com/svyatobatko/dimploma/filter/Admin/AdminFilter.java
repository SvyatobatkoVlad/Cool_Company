package com.svyatobatko.dimploma.filter.Admin;




import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.svyatobatko.dimploma.models.UserData;
import static com.svyatobatko.diploma.controller.login.GetComtrollerLogin.LOGGED_IN_USER_ATTRIBUTE;



@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session != null) {
			UserData user = (UserData)session.getAttribute(LOGGED_IN_USER_ATTRIBUTE);
			if (user.getRole().equals("Admin")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/examplediploma/login.jsp");
			rd.forward(request, response);
		}
		
	}
	
}

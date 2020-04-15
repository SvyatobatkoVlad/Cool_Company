package com.svyatobatko.dimploma.filter.partner;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/public/*")
public class PartnerFilter implements Filter {

	public static final String PARTNER_ID = "partnerId";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String param = request.getParameter(PARTNER_ID);
		if (param != null) {
			Cookie cookie = new Cookie(PARTNER_ID, param);
			((HttpServletResponse) response).addCookie(cookie);
		}
		chain.doFilter(request, response);
	}

}

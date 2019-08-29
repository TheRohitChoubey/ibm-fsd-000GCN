package com.example.filter;

import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import comm.example.factory.MyConnectionFactory;

/**
 * Servlet Filter implementation class EmailFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/verify_employee.dao" })
public class EmailFilter implements Filter {
	private String email;
	private String password;

	/**
	 * Default constructor.
	 */
	public EmailFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		email = request.getParameter("email").toString();
		password = request.getParameter("pass").toString();

		Connection connection = MyConnectionFactory.getMySqlConnectionForHR();

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(
					"select * from employee where email ='" + email + "' AND password ='" + password + "'");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				chain.doFilter(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pass the request along the filter chain

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

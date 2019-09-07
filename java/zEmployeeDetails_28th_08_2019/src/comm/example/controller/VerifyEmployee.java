package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/verify_employee.dao")
public class VerifyEmployee extends HttpServlet {
	private String country, name, email, password;
	private int id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		name = request.getParameter("email");
		password = request.getParameter("pass").toString();
	
		request.setAttribute("SUCCESS", new Employee(name, password));
		RequestDispatcher view = request.getRequestDispatcher("AddEmployee.jsp");
		 view.forward(request, response);
	}

}

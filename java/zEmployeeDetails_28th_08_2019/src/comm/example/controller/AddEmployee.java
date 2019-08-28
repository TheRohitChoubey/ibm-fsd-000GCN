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
@WebServlet("/add_employee.dao")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String country, name, email, password;
	private int id;
	private List<String> errMsgs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployee() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		PrintWriter out = response.getWriter();

		name = request.getParameter("uName");
		email = request.getParameter("uEmail");
		password = request.getParameter("uPass");
		country = request.getParameter("uCountry");

		request.setAttribute("SUCCESS", new Employee(name, password, email, country));
		Connection connection = MyConnectionFactory.getMySqlConnectionForHR();
		PreparedStatement pst = connection.prepareStatement("select max(id) from employee");
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			id = rs.getInt(1);
			out.println("No id found");
		} else {
			id = 0;
		}
		id++;
		out.println(id);
		pst = connection.prepareStatement("insert into employee(id,name,email,password,country) values(?,?,?,?,?)");

		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, email);
		pst.setString(4, password);
		pst.setString(5, country);

		pst.executeUpdate();

		System.out.println("Record Added succesfully");
		 RequestDispatcher view = request.getRequestDispatcher("index.html");
		 view.forward(request, response);

	}

}

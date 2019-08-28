package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;

/**
 * Servlet implementation class DeleteDetail
 */
@WebServlet("/deleteDetail.dao")
public class DeleteDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDetail() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = Integer.parseInt(request.getParameter("id").toString());
		// out.println(id);
		try {
			Connection connection = MyConnectionFactory.getMySqlConnectionForHR();

			PreparedStatement pst = connection.prepareStatement(
					"delete from employee where id=?");

			pst.setInt(1, id);

			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("employee_list.view");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

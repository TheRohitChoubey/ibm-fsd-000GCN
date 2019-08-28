package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;

/**
 * Servlet implementation class ViewEmployeeList
 */
@WebServlet("/employee_list.view")
public class ViewEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmployeeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Connection connection = MyConnectionFactory.getMySqlConnectionForHR();
		PreparedStatement pst = connection.prepareStatement("select * from employee");
		ResultSet rs = pst.executeQuery();

		out.println("<table><tr><td>Id</td><td>Name</td><td>Email</td><td>Password</td>"+
		"<td>Country</td><td>Edit</td><td>Delete</td></tr>");
		while (rs.next()) {
			out.println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td>"
					+ "<td>" + rs.getString(4)+ "</td><td>" + rs.getString(5)+ "</td>"
					+ "<td><a href = 'editDetail.dao?id="+rs.getInt(1)+"'>Edit</a></td><td><a href = 'deleteDetail.dao?id="+rs.getInt(1)+"'>Delete</a></td>"
							+ "</tr>");
		}
		out.println("</table>");

	}

}

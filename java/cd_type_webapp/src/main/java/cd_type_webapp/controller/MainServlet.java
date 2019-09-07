package cd_type_webapp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cd_type_webapp.dao.SpecialEditionCD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.beans.container.internal.CdiBasedBeanContainer;

import cd_type_webapp.dao.InternationalCD;
import cd_type_webapp.dao.LocalCd;
import cd_type_webapp.factory.InstructorFactory;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fname,lname,cd_type;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fname = request.getParameter("fname").toString();
		lname = request.getParameter("lname").toString();
		cd_type = request.getParameter("cd_type").toString();
		Session session = InstructorFactory.getMySession();
		session.getTransaction().begin();
		if(cd_type.equals("local")) {
			LocalCd cd = new LocalCd(fname, lname);
			session.save(cd);
			session.getTransaction().commit();
		}
		else if(cd_type.equals("international")) {
			InternationalCD icd = new InternationalCD(fname, lname);
			session.save(icd);
			session.getTransaction().commit();
		}
		else {
			SpecialEditionCD secd = new SpecialEditionCD(fname,lname);
			session.save(secd);
			session.getTransaction().commit();
		}
		System.out.println("success");
		
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.include(request,response);
		
	}

}

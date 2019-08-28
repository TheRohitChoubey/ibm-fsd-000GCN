package com.example1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example1.model.League;

/**
 * Servlet implementation class ListLeague
 */
@WebServlet("/list_leagues.view")
public class ListLeague extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<League> list=new ArrayList<League>();
		list.add(new League("Soccer League",2009,"Summer"));
		list.add(new League("Swiming League",2019,"Summer"));
		list.add(new League("Basket Ball League",2009,"Autumn"));
		list.add(new League("Beach Volley",2015,"Winter"));
		out.println("<table><tr><td>Title</td><td>Year</td><td>Season</td></tr>");
		for(League l:list)
		{
			out.println("<tr><td>"+l.getLeagueTitle()+"</td><td>"+l.getLeagueYear()+
					"</td><td>"+l.getLeagueSeason()+"</td></tr>");
		}
		out.println("</table>");
		
		
		
	}

}
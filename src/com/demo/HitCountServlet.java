package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HitCountServlet
 */
@WebServlet(name = "HitCount", urlPatterns = { "/HitCount" })
public class HitCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		Integer count = (Integer) session.getAttribute("countVisits");
		if(count == null) {
			count = new Integer(1);
		}
		else {
			count++;
		}
		session.setAttribute("countVisits", count);
		out.println("<h4>You visited here " + count + " time(s)</h4>");
		out.println("ID: " + session.getId());
		out.println("Created: " + new Date(session.getCreationTime()));
		out.println("Recent: " + new Date(session.getLastAccessedTime()));
	}

}

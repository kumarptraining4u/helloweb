package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name = "Cart", urlPatterns = { "/Cart" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String gadgets[] = request.getParameterValues("gadgets");
		String others[] = request.getParameterValues("misc");
		
		HttpSession session = request.getSession(true);
		ArrayList<String> cartList = (ArrayList<String>) session.getAttribute("mycart");
		if(cartList == null) {
			cartList = new ArrayList<String>();
		}
		for(int i=0;i<gadgets.length;i++)
			cartList.add(gadgets[i]);
		
		for(int i=0;i<others.length;i++)
			cartList.add(others[i]);
		
		session.setAttribute("mycart", cartList);
		
		out.println("<body>");
		out.println("<h2>You have the following items in your cart...</h2>");
		out.println("<h4><ul>");
		for(String item : cartList) {
			out.println("<li>" + item + "</li>");
		}
		out.println("</ul></h4>"
				+ "<a href='products.html'>Back to Products</a>"
				+ "</body>");
		
	}

}

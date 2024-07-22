package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InboxServlet
 */
public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		//Cookie
		/*
		 * Cookie[] arr = request.getCookies(); for (Cookie ck:arr) {
		 * pw.println("The cookie name: " + ck.getName());
		 * pw.println("The cookie value: " + ck.getValue()); }
		 */
		HttpSession session = request.getSession();
		if (session.isNew()) {
			pw.println("The session is new, so no attribute is set");
		}
		else {
//			String name = (String)session.getAttribute("name");
			String country = request.getParameter("country");
			String username = request.getParameter("name");
			pw.println("Welcome " + username + ", from " + country);
			pw.println("<html><body><a href='logout'>Logout</a></body></html>");
		}
	}

}

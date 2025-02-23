package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cookies
		/*
		 * String username = request.getParameter("uname"); Cookie cookie = new
		 * Cookie("user", username); response.addCookie(cookie);
		 * response.sendRedirect("Index.html");
		 */
		String username = request.getParameter("uname");
		String value = request.getParameter("hiddenvalue");
		System.out.println(value);
		HttpSession session = request.getSession();  //true by default
		if (session.isNew()) {
//			session.setAttribute("name", username);
			response.sendRedirect("inbox?country=india&name=" + username);
		}
		else {
			response.sendRedirect("Error.html");
		}
		
	}

}

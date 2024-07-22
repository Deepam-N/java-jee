package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> mapOfCountries = new HashMap<>();
		mapOfCountries.put("IND", "India");
		mapOfCountries.put("NZ", "New Zealand");
		
		HttpSession session = request.getSession();
		session.setAttribute("mapOfCountries", mapOfCountries);
		
		/*
		 * request.setAttribute("mapOfCountries", mapOfCountries); RequestDispatcher rd
		 * = request.getRequestDispatcher("login.jsp"); rd.forward(request, response);
		 */
		request.getRequestDispatcher("login.jsp").forward(request, response); 
//		response.sendRedirect("login.jsp");
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname"); 
		String password = request.getParameter("pass"); 
		String country = request.getParameter("country");
		System.out.println(name + " " + country);
		
		PrintWriter pw = response.getWriter();
		
		  if (country.equals("IND") && name.equals("admin") && password.equals("admin")) 
			  pw.print("Welcome, " + name + ". Your country is " + country + "."); 
		  else if (country.equals("NZ") && password.equals("admin123") && name.equals("admin123")) 
			  pw.print("Welcome, " + name + ". Your country is " + country + "."); 
		  else {
			  HttpSession session = request.getSession();
			  session.setAttribute("errorMessage", "Invalid credentials, please try again"); 
			  response.sendRedirect("login.jsp");
		  }
		 
		pw.print("done");
		
	}

}

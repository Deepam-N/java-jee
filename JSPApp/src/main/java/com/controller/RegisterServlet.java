package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> mapOfCountries = new HashMap<>();
		mapOfCountries.put("IND", "India");
		mapOfCountries.put("NZ", "New Zealand");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("mapOfCountries", mapOfCountries);
		response.sendRedirect("register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String password = request.getParameter("pass");
		String country = request.getParameter("country");
		String gender = request.getParameter("gender");
		
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setCountry(country);
		user.setGender(gender);
		
		UserServiceImpl service = new UserServiceImpl();
		
		if (name.equals("") || password.equals("") || country.equals("") || gender.equals("")) {
			request.setAttribute("errorMessage", "Please enter values for all fields.");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		else {
			try {
				if (service.validUser(name)) {
					request.setAttribute("errorMessage", "Username already exists; please log in or register with a different username");
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
				}
				else {
					try {
						if (service.registerUser(user)) {
							request.setAttribute("registrationSuccess", "Thank you for registering! Log in using the link below.");
							RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

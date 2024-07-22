package com.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.model.Product;
import com.inventory.service.ProductImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	 * public RegistrationServlet() { super(); // TODO Auto-generated constructor
	 * stub }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * // protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // // TODO Auto-generated
	 * method stub // }
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void init() {
		System.out.println("Init menthod is called");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String id = request.getParameter("pid");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		
//		PrintWriter pw = response.getWriter();
		Product product = new Product();
		product.setProductName(name);
		product.setProductCategory(category);
		product.setPrice(Integer.parseInt(price));
		
		ProductImpl service = new ProductImpl();
		int pID = service.registerProduct(product);
		if (pID != -1) {
			RequestDispatcher rd = request.getRequestDispatcher("final");
			request.setAttribute("id", pID);
			rd.forward(request, response);
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.print("Couldn't complete action :/");
			pw.close();
		}
	}
	
	public void destroy() {
		System.out.println("Destroy is called");
	}

}

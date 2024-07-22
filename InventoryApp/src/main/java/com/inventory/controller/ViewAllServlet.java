package com.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.model.Product;
import com.inventory.service.ProductImpl;

/**
 * Servlet implementation class ViewAllServlet
 */
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductImpl service = new ProductImpl();
		PrintWriter pw = response.getWriter();
		List<Product> products = new ArrayList<Product>();
		products = service.getAllProducts();
		if (products.isEmpty()) {
			pw.println("Couldn't find any products :/");
		}
		else {
			response.setContentType("text/html");	//Default
			pw.print("<html><body><h3>All Products<br></h3>");
			for (Product p:products) {
				pw.println("<b>Product ID:</b> " + p.getpID());
				pw.print("		<b>Product Name:</b> " + p.getProductName());
				pw.print("		<b>Product Category:</b> " + p.getProductCategory());
				pw.print("		<b>Price:</b> " + p.getPrice());
			}
		}
		pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

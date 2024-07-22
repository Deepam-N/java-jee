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
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductImpl service = new ProductImpl();
		
		String id = request.getParameter("productid");
		int productID = Integer.parseInt(id);
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		
		Product product = new Product();
		
		boolean productFound = service.findProduct(productID);
		
		if (productFound) {
			RequestDispatcher rd = request.getRequestDispatcher("updation");
			System.out.println(productID);
			product.setpID(productID);
			if (name != null)
				product.setProductName(name);
			if (category != null)
				product.setProductCategory(category);
			if (price != null)
				product.setPrice(Integer.parseInt(price));
						
			request.setAttribute("product", product);
			
			rd.forward(request, response);
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.println("Couldn't find product to edit :/");
			pw.close();
		}
	}

}

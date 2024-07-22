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
 * Servlet implementation class UpdationServlet
 */
public class UpdationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product  = (Product)request.getAttribute("product");
//		System.out.println("Obtained param: " + id);
//		product.setpID(Integer.parseInt(id));	
//		System.out.println("Updation: " + request.getAttribute("id"));
		
		ProductImpl service = new ProductImpl();
		PrintWriter pw = response.getWriter();
		
		if (service.editProduct(product)) {
			pw.println("Success!");
		}
		else {
			pw.print("Couldn't update product details:/");
		}
		pw.close();
	}

}

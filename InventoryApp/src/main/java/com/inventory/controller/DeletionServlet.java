package com.inventory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.model.Product;
import com.inventory.service.ProductImpl;

/**
 * Servlet implementation class DeletionServlet
 */
public class DeletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productid");
		Product product = new Product();
		product.setpID(Integer.parseInt(id));
		ProductImpl service = new ProductImpl();
		
		PrintWriter pw = response.getWriter();
		if (service.deleteProduct(product.getpID())==true) {
			pw.println("Success!");
		}
		else {
			pw.println("Couldn't delete product :/");
		}
		pw.close();
	}

}

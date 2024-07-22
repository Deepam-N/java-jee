package com.inventory.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inventory.dao.ProductDAOImpl;
import com.inventory.model.Product;

public class ProductImpl implements IProduct {

	@Override
	public int registerProduct(Product product) {
		// TODO Auto-generated method stub
		ProductDAOImpl productDAO = new ProductDAOImpl();
		try {
			return productDAO.registerProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean findProduct(int productID) {
		ProductDAOImpl productDAO = new ProductDAOImpl();
		try {
			return productDAO.findProduct(productID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean editProduct(Product product) {
		ProductDAOImpl productDAO = new ProductDAOImpl();
			try {
				return productDAO.editProduct(product);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean deleteProduct(int productID) {
		ProductDAOImpl productDAO = new ProductDAOImpl();
		try {
			return productDAO.deleteProduct(productID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		ProductDAOImpl productDAO = new ProductDAOImpl();
		List<Product> products = new ArrayList<Product>();
		try {
			products = productDAO.getAllProducts();
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

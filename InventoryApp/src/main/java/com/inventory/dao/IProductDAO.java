package com.inventory.dao;

import java.sql.SQLException;
import java.util.List;

import com.inventory.model.Product;

public interface IProductDAO {
	int registerProduct(Product product) throws SQLException;
	boolean findProduct(int productID) throws SQLException;
	boolean editProduct(Product product) throws SQLException;
	boolean deleteProduct(int productID) throws SQLException;
	List<Product> getAllProducts() throws SQLException;
}

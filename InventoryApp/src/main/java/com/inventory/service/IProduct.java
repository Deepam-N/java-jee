package com.inventory.service;

import java.util.List;

import com.inventory.model.Product;

public interface IProduct {
	int registerProduct(Product product);
	boolean editProduct(Product product);
	boolean deleteProduct(int productID);
	List<Product> getAllProducts();
}

package com.inventory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inventory.model.Product;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public int registerProduct(Product product) throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root"); //location, username, password
			if (conn != null) {	//If connection is established
				System.out.println("Registering product: connection established");
				String insertQuery = "insert into product(productname, category, price) values (?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);		//Preparing the statement
				pstmt.setString(1, product.getProductName());
				pstmt.setString(2, product.getProductCategory());
				pstmt.setInt(3, product.getPrice());
				int k = pstmt.executeUpdate();	//Executes the query
				if (k>0)
					return ProductDAOImpl.getProductID(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	public static int getProductID(Product product) {
		int id = -1;
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root"); //location, username, password
			if (conn != null) {	//If connection is established
				System.out.println("Finding product by ID: connection established");
				String selectQuery = "select pid from product where productname = ? and category = ? and price = ?";
				PreparedStatement pstmt = conn.prepareStatement(selectQuery);
				pstmt.setString(1, product.getProductName());
				pstmt.setString(2, product.getProductCategory());
				pstmt.setInt(3, product.getPrice());
				ResultSet rs = pstmt.executeQuery();	//Executes the query
//				System.out.println("before assignment: "+ id);
				if (rs.next()) {
					id = rs.getInt(1);
//					System.out.println("after assignment: " + id);
					if (id != 0)
						return id;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	@Override
	public boolean findProduct(int productID) throws SQLException {
//		Product product = new Product();
		Connection conn = null;
		try {	//Registering the driver ()
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root"); //location, username, password
			if (conn != null) {
				System.out.println("Finding product: connection established");//Test for connection
				String searchQuery = "select * from product where pid = ?";
				PreparedStatement psmt = conn.prepareStatement(searchQuery);	//Preparing the statement	
				psmt.setInt(1, productID);
				ResultSet rs = psmt.executeQuery();	//Executes the query
				if (rs.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return false;
	}
	
	@Override
	public boolean editProduct(Product product) throws SQLException {
		Connection conn = null;
		try {	//Registering the driver ()
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root"); //location, username, password
			if (conn != null) {
				System.out.println("Editing product: connection established");//Test for connection
				int flag = 1;
				//Case 1: Update name
				if (!product.getProductName().equals("")) {
					System.out.println("Case 1: Update name");
					String updateQuery = "update product set productname = ? where pid = ?";
					PreparedStatement psmt = conn.prepareStatement(updateQuery);	//Preparing the statement	
					psmt.setString(1, product.getProductName());
					psmt.setInt(2, product.getpID());
					int k = psmt.executeUpdate();	//Executes the query
					if (k<=0) {
						flag = -1;
						return false;
					}
				}
				//Case 2:Update category
				if (!product.getProductCategory().equals("")) {
					System.out.println("Case 2:Update category");
					String updateQuery = "update product set category = ? where pid = ?";
					PreparedStatement psmt = conn.prepareStatement(updateQuery);	//Preparing the statement	
					psmt.setString(1, product.getProductCategory());
					psmt.setInt(2, product.getpID());
					int k = psmt.executeUpdate();	//Executes the query
					if (k<=0){
						flag = -1;
						return false;
					}
				}
				//Case 3: Update price
				if (product.getPrice() > 0) {
					System.out.println("Case 3: Update price");
					String updateQuery = "update product set price = ? where pid = ?";
					PreparedStatement psmt = conn.prepareStatement(updateQuery);	//Preparing the statement	
					psmt.setInt(1, product.getPrice());
//					System.out.println("New price: " + product.getPrice());
					psmt.setInt(2, product.getpID());
//					System.out.println("Product ID: " + product.getpID());
//					System.out.println("Statement prepared");
					int k = psmt.executeUpdate();	//Executes the query
//					System.out.println("Statement executed: " + k);
					if (k<=0){
						flag = -1;
						return false;
					}
				}
				if (flag == 1)
					return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productID) throws SQLException {
		Connection conn = null;
		try {	//Registering the driver ()
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root"); //location, username, password
			if (conn != null) {
				System.out.println("Deleting product: connection established");//Test for connection
				String deleteQuery = "delete from product where pid = ?";
				PreparedStatement psmt = conn.prepareStatement(deleteQuery);	//Preparing the statement	
				psmt.setInt(1, productID);
				int k = psmt.executeUpdate();	//Executes the query
				if (k>0)
					return true;
				else
					return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return false;
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		List <Product> products = new ArrayList<Product>();
		Connection conn = null;
		try {	//Registering the driver ()
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root"); //location, username, password
			if (conn != null) {
				System.out.println("Listing all products: connection established");//Test for connection
				String searchQuery = "select * from product";
				PreparedStatement psmt = conn.prepareStatement(searchQuery);	//Preparing the statement	
				ResultSet rs = psmt.executeQuery();	//Executes the query
				while (rs.next()) {
					Product p = new Product();
					p.setpID(rs.getInt("pid"));
					p.setProductName(rs.getString("productname"));
					p.setProductCategory(rs.getString("category"));
					p.setPrice(rs.getInt("price"));
					products.add(p);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return products;
	}

}

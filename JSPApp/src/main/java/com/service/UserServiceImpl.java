package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserServiceImpl implements IUserService {

	@Override
	public boolean registerUser(User user) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root"); //location, username, password
			if (conn != null) {	//If connection is established
				System.out.println("Registering user: connection established");
				String insertQuery = "insert into user values (?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);		//Preparing the statement
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getCountry());
				pstmt.setString(4, user.getGender());
				int k = pstmt.executeUpdate();	//Executes the query
				if (k>0)
					return true;
				else
					return false;
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
		return false;
	}

	@Override
	public boolean validUser(String username) throws SQLException {
		Connection conn = null;
		try {	//Registering the driver ()
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root"); //location, username, password
			if (conn != null) {
				System.out.println("Finding user: connection established");//Test for connection
				String searchQuery = "select * from user where username = ?";
				PreparedStatement psmt = conn.prepareStatement(searchQuery);	//Preparing the statement	
				psmt.setString(1, username);
				ResultSet rs = psmt.executeQuery();	//Executes the query
				if (rs.next()) {
					return true;
				}
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
	public boolean validateUser(User user) throws SQLException {
		Connection conn = null;
		try {	//Registering the driver ()
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root"); //location, username, password
			if (conn != null) {
				System.out.println(" user: connection established");//Test for connection
				String searchQuery = "select password from user where username = ?";
				PreparedStatement psmt = conn.prepareStatement(searchQuery);	//Preparing the statement	
				psmt.setString(1, user.getUserName());
				ResultSet rs = psmt.executeQuery();	//Executes the query
				if (rs.next()) {
					if (user.getPassword().equals(rs.getString(1)))
						return true;
					else
						return false;
				}
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

}

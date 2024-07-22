package com.service;

import java.sql.SQLException;

import com.model.User;

public interface IUserService {
	public boolean registerUser(User user) throws SQLException;
	public boolean validUser(String username) throws SQLException;
	public boolean validateUser(User user) throws SQLException;
}

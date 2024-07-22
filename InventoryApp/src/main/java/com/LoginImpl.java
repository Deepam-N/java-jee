package com;

public class LoginImpl implements ILogin {

	@Override
	public boolean validateCredentials(Login login) {
		// TODO Auto-generated method stub
		ILoginDAO dao = new LoginDAOImpl();
		return dao.validateCredentials(login);	//calls DAO layer
	}

}

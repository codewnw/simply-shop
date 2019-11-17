package com.simplyshop.service;

import com.simplyshop.dao.LoginDao;
import com.simplyshop.dao.LoginDaoImpl;
import com.simplyshop.model.Login;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public void save(Login login) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean check(Login login) {
		return loginDao.check(login);
	}

}

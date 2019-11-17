package com.simplyshop.dao;

import com.simplyshop.model.Login;

public interface LoginDao {
	void save(Login login);

	boolean check(Login login);
}

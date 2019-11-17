package com.simplyshop.service;

import com.simplyshop.model.Login;

public interface LoginService {
	void save(Login login);

	boolean check(Login login);
}

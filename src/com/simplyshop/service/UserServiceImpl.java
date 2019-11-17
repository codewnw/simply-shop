package com.simplyshop.service;

import java.util.List;

import com.simplyshop.dao.UserDao;
import com.simplyshop.dao.UserDaoImpl;
import com.simplyshop.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void save(User user) {
		System.out.println(">> save of " + this.getClass().getSimpleName());
		userDao.save(user);
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}

	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub

	}

}

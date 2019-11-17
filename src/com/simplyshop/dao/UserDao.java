package com.simplyshop.dao;

import java.util.List;

import com.simplyshop.model.User;

public interface UserDao {
	void save(User user);

	User get(String email);

	List<User> get();

	void update(User user);

	void delete(String email);
}

package com.simplyshop.service;

import java.util.List;

import com.simplyshop.model.User;

public interface UserService {

	void save(User user);

	User get(String email);

	List<User> get();

	void update(User user);

	void delete(String email);
}

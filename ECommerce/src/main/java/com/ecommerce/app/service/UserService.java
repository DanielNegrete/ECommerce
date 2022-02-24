package com.ecommerce.app.service;

import java.util.List;

import com.ecommerce.app.entity.User;

public interface UserService {

	void saveUser(User user);

	List<User> authenticateUser(String name, String password);

}

package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entity.User;

public interface UserDao {

	void saveUser(User user);

	List<User> authenticateUser(String name, String password);

}

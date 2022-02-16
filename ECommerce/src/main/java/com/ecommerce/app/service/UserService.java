package com.ecommerce.app.service;

import com.ecommerce.app.entity.User;

public interface UserService {

	void saveUser(User user);

	User authenticateUser(String name, String password);

}

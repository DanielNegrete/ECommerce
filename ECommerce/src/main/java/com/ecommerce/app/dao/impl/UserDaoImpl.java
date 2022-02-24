package com.ecommerce.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.UserDao;
import com.ecommerce.app.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	//static HashMap<String, User> userDatabase = new HashMap<>();
	
	@Override
	public void saveUser(User user) {
		//userDatabase.put(user.getName(), user);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(user);
		session.getTransaction().commit();
		session.close();
		System.out.println(user.getName() + " details saved");
	}

	@Override
	public List<User> authenticateUser(String name, String password) {
		//User user = userDatabase.get(name);
		//if(user.getPassword().equals(password)) return user;
		List<User> userV = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("FROM User U WHERE U.name = :name and U.password = :password");
		query.setParameter("name", name)
			 .setParameter("password", password);
		userV = query.list();
		
		session.close();
		return userV;
	}
}

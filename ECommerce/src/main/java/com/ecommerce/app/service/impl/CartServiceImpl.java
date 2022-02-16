package com.ecommerce.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.entity.Order;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;

	@Override
	public void addCartProduct(Product product) {
		cartDao.addCartProduct(product);
	}

	@Override
	public List<Product> getCartProducts() {
		return cartDao.getCartProducts();
	}

	@Override
	public boolean existProduct(Product product) {
		return cartDao.existProduct(product);
	}

	@Override
	public double getTotal() {
		return cartDao.getTotal();
	}

	@Override
	public void makeOrder(Integer userId, double total, List<Product> cartProducts) {
		cartDao.makeOrder(userId, total, cartProducts);
	}

	@Override
	public List<Order> getOrderList(Integer userId) {
		// TODO Auto-generated method stub
		return cartDao.getOrderList(userId);
	}

}

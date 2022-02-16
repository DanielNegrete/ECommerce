package com.ecommerce.app.service;

import java.util.List;

import com.ecommerce.app.entity.Order;
import com.ecommerce.app.entity.Product;

public interface CartService {

	void addCartProduct(Product product);

	List<Product> getCartProducts();

	boolean existProduct(Product product);

	double getTotal();

	void makeOrder(Integer userId, double total, List<Product> cartProducts);

	List<Order> getOrderList(Integer userId);

}

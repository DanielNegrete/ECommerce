package com.ecommerce.app.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.entity.Order;
import com.ecommerce.app.entity.Product;

@Repository
public class CartDaoImpl implements CartDao{
	
	static int cont=0;
	static double total;
	static List<Product> cartProducts = new ArrayList<>();
	static List<Product> orderProducts = new ArrayList<>();
	List<Order> ordersList = new ArrayList<>();
	static HashMap<Integer, Order> orderDatabase = new HashMap<>();
	
	
	@Override
	public void addCartProduct(Product product) {
		product.setProductQuantity(1.0);
		cartProducts.add(product);
	}

	@Override
	public List<Product> getCartProducts() {
		return cartProducts;
	}

	@Override
	public boolean existProduct(Product product) {
		for (Product obj : cartProducts) {
			  if(obj.getProductId().equals(product.getProductId())) { 
				  obj.setProductQuantity(obj.getProductQuantity() + 1.0);
				  return true;
			  }
			}	
		return false;
	}

	@Override
	public double getTotal() {
		total = 0;
		for (Product obj : cartProducts) {
			total +=(obj.getProductPrice() * obj.getProductQuantity());
		}	
		return total;
	}

	@Override
	public void makeOrder(Integer userId, double total, List<Product> cartProducts) {
		Order order = new Order();		
		for (Product obj : cartProducts) {
			orderProducts.add(obj);
		}	
		order.setOrderId(cont++);
		order.setUserId(userId);
		order.setTotal(total);
		order.setDateTime(LocalDateTime.now());
		order.setProducts(orderProducts);
		orderDatabase.put(order.getUserId(), order);
	}

	@Override
	public List<Order> getOrderList(Integer userId) {
		for (Order value : orderDatabase.values()) {
			if(value.getUserId() != userId)	
				ordersList.remove(value);
			if(value.getUserId().equals(userId))
				ordersList.add(value);
		}
		 cartProducts.removeAll(cartProducts);
		return ordersList;
	}
}

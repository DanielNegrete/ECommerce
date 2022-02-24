package com.ecommerce.app.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.ProductCart;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static int cont=0;
	static double total;
	static List<Product> cartProducts = new ArrayList<>();
	//static List<Product> orderProducts = new ArrayList<>();
	//static HashMap<Integer, Cart> orderDatabase = new HashMap<>();
	
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
		Cart cart = new Cart();		
		//for (Product obj : cartProducts) {
			//orderProducts.add(obj);
		//}	
		cart.setOrderId(cont++);
		cart.setUserId(userId);
		cart.setTotal(total);
		cart.setDateTime(LocalDateTime.now());
		
		
		for(Product obj : cartProducts) {
			ProductCart productCart = new ProductCart();
			
			productCart.setOrderId(cart.getOrderId());
			productCart.setProductName(obj.getProductName());
			productCart.setProductQuantity(obj.getProductQuantity());
			productCart.setProductPrice(obj.getProductPrice());
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.persist(productCart);
			session.getTransaction().commit();
			session.close();
		}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(cart);
		session.getTransaction().commit();
		session.close();
		
		cartProducts.clear();
		//order.setProducts(orderProducts);
		//orderDatabase.put(order.getUserId(), order);
	}

	@Override
	public List<Cart> getOrderList(Integer userId) {
		List<Cart> ordersList = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Cart C WHERE C.userId = :userId");
		query.setParameter("userId", userId);
		ordersList = query.list();
		session.close();
		
		return ordersList;
		/*
		for (Cart value : orderDatabase.values()) {
			if(value.getUserId() != userId)	
				ordersList.remove(value);
			if(value.getUserId().equals(userId))
				ordersList.add(value);
		}
		 cartProducts.removeAll(cartProducts);
		return ordersList;
		*/
	}

	@Override
	public List<ProductCart> getProductsCart(Integer userId) {
		List<ProductCart> productsCart = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM ProductCart");
		//"SELECT P.orderId, P.productName, P.productQuantity, P.productPrice FROM ProductCart P INNER JOIN Cart C ON P.orderId=C.orderId WHERE C.userId = :userId"
		//query.setParameter("userId", userId);
		productsCart = query.list();
		session.close();
		
		return productsCart;
	}
}

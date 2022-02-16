package com.ecommerce.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.ProductDao;
import com.ecommerce.app.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	

	public List<Product> getProducts() {
		List<Product> productsList = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Samsung A20");
		product1.setProductCategory("Phone");
		product1.setProductPrice(191);
		product1.setProductQuantity(50);
		
		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("IPhone 11");
		product2.setProductCategory("Phone");
		product2.setProductPrice(1099);
		product2.setProductQuantity(20);
		
		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName("MacBook Air");
		product3.setProductCategory("Computers");
		product3.setProductPrice(1820);
		product3.setProductQuantity(10);
		
		Product product4 = new Product();
		product4.setProductId(4);
		product4.setProductName("Microsoft Surface Pro");
		product4.setProductCategory("Computers");
		product4.setProductPrice(1200);
		product4.setProductQuantity(22);
		
		productsList.add(product1);
		productsList.add(product2);
		productsList.add(product3);
		productsList.add(product4);
		
		return productsList;
	}
}

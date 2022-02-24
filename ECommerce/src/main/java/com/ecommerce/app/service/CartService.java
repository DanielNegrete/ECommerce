package com.ecommerce.app.service;

import java.util.List;

import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.ProductCart;

public interface CartService {

	void addCartProduct(Product product);

	List<Product> getCartProducts();

	boolean existProduct(Product product);

	double getTotal();

	void makeOrder(Integer userId, double total, List<Product> cartProducts);

	List<Cart> getOrderList(Integer userId);

	List<ProductCart> getProductsCart(Integer userId);

}

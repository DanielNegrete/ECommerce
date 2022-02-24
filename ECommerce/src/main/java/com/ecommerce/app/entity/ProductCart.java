package com.ecommerce.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productCartId;
	private Integer orderId;
	private String productName;
	private double productQuantity;
	private double productPrice;
	
	
	public Integer getProductCartId() {
		return productCartId;
	}
	public void setProductCartId(Integer productCartId) {
		this.productCartId = productCartId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}

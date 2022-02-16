package com.ecommerce.app;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Order;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.CartService;

@Controller
public class CartController {
	
	static double total;
	Integer userId;
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/addCartProduct", method = RequestMethod.POST)
	public String addCartProduct(@ModelAttribute Product product, @RequestParam("userId") Integer userId, Model model) {
		this.userId = userId;
		if(!cartService.existProduct(product)) cartService.addCartProduct(product);
		System.out.println(product.getProductName() + " added to cart");
		model.addAttribute("userId", userId);
		return "redirect:/getProducts";
	}
	
	@RequestMapping(value = "/viewCart/{userId}", method = RequestMethod.GET)
	public String viewCart(@PathVariable("userId") Integer userId, Model model) {
		List<Product> cartProducts = cartService.getCartProducts();
		total = cartService.getTotal();
		
		model.addAttribute("userId", userId);
		model.addAttribute("cartProducts", cartProducts);
		model.addAttribute("total", total);
		return "viewCart";
	}
	
	@RequestMapping(value = "/buyCart/{userId}", method = RequestMethod.GET)
	public ModelAndView buyCart(@PathVariable("userId") Integer userId, ModelAndView modelAndView) {
		List<Product> cartProducts = cartService.getCartProducts();
		total = cartService.getTotal();
		cartService.makeOrder(userId, total, cartProducts);
		
		List<Order> orderList = cartService.getOrderList(userId);
		
		modelAndView.addObject("userId", userId);
		modelAndView.addObject("orderList", orderList);
		modelAndView.setViewName("confirmation");
		return modelAndView;
	}
}

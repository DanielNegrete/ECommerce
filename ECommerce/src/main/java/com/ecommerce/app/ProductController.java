package com.ecommerce.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public ModelAndView getAllProducts(@RequestParam("userId") Integer userId, ModelAndView modelAndView) {
		List<Product> productsList = productService.getProductsList();
		
		modelAndView.addObject("userId", userId);
		modelAndView.addObject("productsList", productsList);
		modelAndView.setViewName("productsview");
		return modelAndView;
	}
}

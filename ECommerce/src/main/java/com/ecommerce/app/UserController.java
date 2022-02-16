package com.ecommerce.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.dto.Credential;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showRegistrationPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String doRegistration(@ModelAttribute User user, Model model) {
		userService.saveUser(user);
		Credential credential = new Credential();
		model.addAttribute("credential", credential);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticateUser(@ModelAttribute Credential credential, Model model) {
		User user = userService.authenticateUser(credential.getName(), credential.getPassword());
		
		if(ObjectUtils.isEmpty(user))return "loginfailure";
		
		model.addAttribute("userId", user.getUserId());
		return "redirect:/getProducts";
	}
}

package com.cvsHealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvsHelath.Model.User;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@ModelAttribute("userForm")
	public User user() {
		System.out.println("111111");
		return new User();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration() {
		System.out.println("2222222");
		return "register";
	}
}

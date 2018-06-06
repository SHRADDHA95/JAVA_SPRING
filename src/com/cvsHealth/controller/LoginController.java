package com.cvsHealth.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvsHealth.CustomExceptionHandler.UserNotFoundException;
import com.cvsHealth.service.UserAuthentication;
import com.cvsHealth.service.UserAuthenticationService;
import com.cvsHelath.Model.User;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewLoginPage() {
		System.out.println("Inside viewLoginPage");
		return "login";
	}

	@ModelAttribute("loginCredentials")
	public User user() {
		return new User();
	}

	@Autowired
	UserAuthenticationService userAuthenticationService;
	
	
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String processRegistration(User user, Model model, HttpServletRequest req, HttpServletResponse res){

		// for testing purpose
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		model.addAttribute("loginCredentials", user);
		try {
			if (userAuthenticationService.verifyuser(user)) {

				HttpSession session = req.getSession();
				session.setAttribute("userKey", user);
				return "loginSuccess";
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "error";
	}

	/* return "error"; */

}

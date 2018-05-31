package com.cvsHealth.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvsHealth.AppData.JSONReader;
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

	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String processRegistration(User user, Model model, HttpServletRequest req, HttpServletResponse res)
			throws FileNotFoundException, IOException, ParseException {

		// for testing purpose

		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		model.addAttribute("loginCredentials", user);

		/** Validating user credentials **/
		JSONReader reader = new JSONReader();
		List<User> valFromJSON = reader.readFromJSON();
		if (user != null) {
			for (User u : valFromJSON) {
				String uName = u.getUsername();
				String uPassword = u.getPassword();
				if ((uName.equals(user.getUsername())) && (uPassword.equals(user.getPassword()))) {
                
					HttpSession session=req.getSession();
                    session.setAttribute("userKey", u);
                
                
					return "loginSuccess";

				}

			}
		}

		return "error";

	}

}

package com.cvsHealth.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cvsHealth.AppData.JSONWriter;
import com.cvsHelath.Model.User;

@Controller
@RequestMapping(value = "/register/")
public class RegisterController {

	@ModelAttribute("userForm")
	public User user() {
		return new User();
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String processRegistration(@RequestParam("pageId") String id, User user, Model model)
			throws FileNotFoundException, IOException, ParseException {

		JSONWriter obj = new JSONWriter();
		obj.writeIntoJSON(user);
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("birth date: " + user.getDOB());
		for (String lang : user.getFavLanguages()) {

			System.out.println("Fav lang:" + lang);
		}
		if (id.equals("2")) {
			model.addAttribute("userForm", user);
			return "redirect:/";
		} else

			return "redirect:/userList";
	}
}
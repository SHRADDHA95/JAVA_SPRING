package com.cvsHealth.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cvsHealth.AppData.JSONReader;
import com.cvsHealth.AppData.JSONWriter;
import com.cvsHelath.Model.User;

@Controller
@RequestMapping(value = "/userList")
public class ViewUserResult {

	/* Populate list on JSP */
	@RequestMapping
	public String listEmployee(Model model)  {
		try {
			System.out.println("ViewUserResult Controller");
			
            model.addAttribute("lists", this.getUserList());
			return "userList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* Remove selected user */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeUser(@RequestParam("username") String username,Model model)
			throws FileNotFoundException, IOException, ParseException {
		try {
			JSONReader reader = new JSONReader();
			System.out.println("Inside remove, user name:" + username);
			List<User> valFromJSON = reader.readFromJSON();
			List<User> list = new ArrayList<>();
			if (username != null) {
				for (User u : valFromJSON) {
					String uName = u.getUsername();
					if (!uName.equals(username)) {
						list.add(u);
					}
				}
			} else {
				System.out.println("USERNAME NOT FOUND**********");
			}
			JSONWriter.writeJSON(list);
			model.addAttribute("lists", this.getUserList());
			model.addAttribute("successMessage", "User Deleted Successfully");
			return "userList";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "Unable to Delete User. Please Login Again");
			return "redirect:/login";
		}
	}

	/* Update selected user */

	@ModelAttribute("userForm")
	public User user() {
		return new User();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(User user, Model model) throws FileNotFoundException, IOException, ParseException {
		try {
			System.out.println("Inside Update");
			JSONReader reader = new JSONReader();
			List<User> valFromJSON = reader.readFromJSON();
			List<User> list = new ArrayList<>();
			if (user != null) {
				for (User u : valFromJSON) {
					String uName = u.getUsername();
					if (uName.equals(user.getUsername())) {
						User userObj = new User();
						userObj.setUsername(user.getUsername());
						userObj.setDOB(user.getDOB());
						userObj.setEmail(user.getEmail());
						list.add(userObj);
					} else {
						list.add(u);
					}
				}
			} else {
				System.out.println("USERNAME NOT FOUND**********");
			}

			JSONWriter.writeJSON(list);
			model.addAttribute("lists", this.getUserList());
			model.addAttribute("successMessage", "User updated Successfully");
			return "userList";

			//return "redirect:/userList";

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<User> getUserList() throws FileNotFoundException, IOException, ParseException{
		JSONReader reader = new JSONReader();
		List<User> valFromJSON = reader.readFromJSON();
		return valFromJSON;
	}

	/*
	 * add user on User Master Screen
	 * 
	 * @RequestMapping(value="/addUser", method = RequestMethod.POST ) public String
	 * addUser(User user) { System.out.println("Inside Add user"); return
	 * "redirect:/userList"; }
	 */

}

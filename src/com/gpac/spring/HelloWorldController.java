package com.gpac.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest req,
			HttpServletResponse res) {
		
		System.out.println("********* SHRADDHA");

		String name = req.getParameter("name");
		String password = req.getParameter("password");

		if (password.equals("admin")) {
			String message = "HELLO " + name;
			return new ModelAndView("hello", "message", message);
		}

		else
			return new ModelAndView("error", "message",
					"Sorry, username or password error");

	}

}

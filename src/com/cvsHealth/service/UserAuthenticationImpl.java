package com.cvsHealth.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.cvsHealth.AppData.JSONReader;
import com.cvsHealth.CustomExceptionHandler.UserNotFoundException;
import com.cvsHelath.Model.User;

@Repository
public class UserAuthenticationImpl implements UserAuthentication {
    
	
	@Override
	public boolean verifyuser(User user)
			throws UserNotFoundException, FileNotFoundException, IOException, ParseException {

		JSONReader reader = new JSONReader();
		List<User> valFromJSON = reader.readFromJSON();
		if (user != null) {
			for (User u : valFromJSON) {
				String uName = u.getUsername();
				String uPassword = u.getPassword();
				if ((uName.equals(user.getUsername())) && (uPassword.equals(user.getPassword()))) {

					// HttpSession session = req.getSession();
					// session.setAttribute("userKey", u);

					return true;

					
				} else
					throw new UserNotFoundException("Could not find user with name:" + user.getUsername());
			}

		}
		return false;
	}
}

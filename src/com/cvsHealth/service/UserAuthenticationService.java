package com.cvsHealth.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvsHealth.CustomExceptionHandler.UserNotFoundException;
import com.cvsHelath.Model.User;

@Service
public class UserAuthenticationService {
	
	@Autowired
	private UserAuthentication userAuthentication;

	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}

	public void setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
	}
	
	public boolean verifyuser(User user) 
			throws UserNotFoundException, FileNotFoundException, IOException, ParseException{
		return this.userAuthentication.verifyuser(user); 
	}
	
}

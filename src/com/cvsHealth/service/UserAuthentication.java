package com.cvsHealth.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.cvsHealth.CustomExceptionHandler.UserNotFoundException;
import com.cvsHelath.Model.User;

@Service
public interface UserAuthentication {

	public boolean verifyuser(User user) throws UserNotFoundException, FileNotFoundException, IOException, ParseException;

}

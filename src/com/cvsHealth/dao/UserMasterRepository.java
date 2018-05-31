package com.cvsHealth.dao;

import java.util.List;

import com.cvsHelath.Model.User;

public interface UserMasterRepository {
	
	List<User> getAllUser();
	boolean saveUser(User bean);
	
}

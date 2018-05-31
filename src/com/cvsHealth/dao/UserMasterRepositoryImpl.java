package com.cvsHealth.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cvsHelath.Model.User;

public class UserMasterRepositoryImpl implements UserMasterRepository {

	private JdbcTemplate jdbcTemplate; 
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean saveUser(User bean) {
		// TODO Auto-generated method stub	
		try {
			String sql = "insert into";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}

	
}

package com.cvsHelath.Model;

public class User {

	private String password;
	private String email;
	private String DOB;
	private String username;
	private String[] favLanguages;
	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

	public String[] getFavLanguages() {
		return favLanguages;
	}

	public void setFavLanguages(String[] favLanguages) {
		this.favLanguages = favLanguages;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {

		this.DOB = dOB;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email + ", DOB=" + DOB + ", username=" + username + "]";
	}
	

}

package com.coderscampus;

public class User {

	// instance variables
	private String username;
	private String password;
	private String name;

	// constructor for all 3 variables
	User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	// getters and setters for each of the 3 instance variables
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

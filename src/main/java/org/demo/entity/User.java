package org.demo.entity;

public class User {
	private int users_id;
	private String username;
	private String email;

	public User(int users_id, String username, String email) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.email = email;
	}
	
	

	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}



	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

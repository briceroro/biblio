package com.mairie.biblio.biblioWebApp.model;

public class UserBean {

	private int id;

	private String email;

	private String password;
	
	private String name;
	
	private String lastName;
	
	//pour spirng security
	public String username;
	
	private boolean active;
	
	private String role;
	
	
	public UserBean() {
		
	}
	
	public UserBean(String email,String password,String name,String lastName,
			String username,Boolean active,String role) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.active =active;
		this.role = role;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

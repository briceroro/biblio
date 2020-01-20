package com.mairie.biblio.biblioWebservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "password")
	@Length(min = 5)
	private String password;
	
	private String name;
	
	private String lastName;
	
	@Column(unique = true)
	public String username;
	
	private boolean active;
	
	private String role;
	
	
	public User() {
		
	}
	
	public User(String email,String password,String name,String lastName,
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

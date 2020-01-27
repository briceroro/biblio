package com.mairie.biblio.biblioWebApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean servant un user aprés l'avoir récupéré via le webservice
 * @author briceroro
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class UserBean {

	private int id;

	private String email;

	private String password;
	
	private String name;
	
	private String lastName;
	
	public String username;
	
	private boolean active;
	
	private String role;
	
	
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

}

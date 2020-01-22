package com.mairie.biblio.biblioWebservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

}

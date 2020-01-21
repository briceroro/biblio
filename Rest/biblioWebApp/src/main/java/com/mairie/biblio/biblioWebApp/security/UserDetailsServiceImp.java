package com.mairie.biblio.biblioWebApp.security;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mairie.biblio.biblioWebApp.model.UserBean;
import com.mairie.biblio.biblioWebApp.proxies.UserProxy;

/**
 * Class servant a modifié UserDetailsService
 * 
 * @author briceroro
 *
 */
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
    private UserProxy userProxy;
	
	  /**
	   * Methode servant a a indiquer les parametres custom de User
	   */
	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    /*Here we are using dummy data, you need to load user data from
	     database or other third party application*/
	    UserBean user = userProxy.findByUsername(username);

	    UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(user.getPassword());
	      builder.roles(user.getRole());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	  }

	  
	}
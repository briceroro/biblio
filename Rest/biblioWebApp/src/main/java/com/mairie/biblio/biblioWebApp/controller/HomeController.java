package com.mairie.biblio.biblioWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mairie.biblio.biblioWebApp.model.UserBean;
import com.mairie.biblio.biblioWebApp.proxies.UserProxy;

@Controller
public class HomeController {
	
	@Autowired
    private UserProxy userProxy;
	
	@GetMapping(value="/")
	public String home(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByName(auth.getName());
		String usernameString = user.getUserName();
		model.addAttribute("username", usernameString);

		return "home";
	}
	

}

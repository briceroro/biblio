package com.mairie.biblio.biblioWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mairie.biblio.biblioWebApp.model.UserBean;
import com.mairie.biblio.biblioWebApp.proxies.UserProxy;

/**
 * Controller servant a recupérer la page home de l'application
 * @author briceroro
 *
 */
@Controller
public class HomeController {
	
	@Autowired
    private UserProxy userProxy;
	
	/**
	 * Methode de request Get de la page home qui récupere l'user identifié
	 * @param model afin d'ajouter l'user au model
	 * @return la page d'acceuil du site
	 */
	@GetMapping(value="/")
	public String home(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByName(auth.getName());
		String usernameString = user.getName();
		model.addAttribute("username", usernameString);

		return "home";
	}
	

}

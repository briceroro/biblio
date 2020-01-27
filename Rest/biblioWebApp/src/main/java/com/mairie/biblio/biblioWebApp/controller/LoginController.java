package com.mairie.biblio.biblioWebApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller de la page login de l'applcication
 * @author briceroro
 *
 */
@Controller
public class LoginController {

	/**
	 * Methode request get pour la page login
	 * @return la page de login
	 */
	@GetMapping(value="/loginForm")
	public String home(){

		return "loginForm";
	}
	
	/**
	 * Methode request pour la page login
	 * @return la page de login
	 */
	@PostMapping(value="/loginForm")
	public String homePOST(){

		return "loginForm";
	}
}

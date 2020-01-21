package com.mairie.biblio.biblioWebApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value="/loginForm", method = RequestMethod.GET)
	public String home(){

		return "loginForm";
	}
	
	/**
	 * Methode request pour la page login
	 * @return la page de login
	 */
	@RequestMapping(value="/loginForm", method = RequestMethod.POST)
	public String homePOST(){

		return "loginForm";
	}
}

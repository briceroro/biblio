package com.mairie.biblio.biblioWebApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mairie.biblio.biblioWebApp.model.BorrowedBookBean;
import com.mairie.biblio.biblioWebApp.model.UserBean;
import com.mairie.biblio.biblioWebApp.proxies.BorrowedBookProxy;
import com.mairie.biblio.biblioWebApp.proxies.UserProxy;

/**
 * Controller servant a recuperer la page des borrowedBook de l'user identifé
 * @author briceroro
 *
 */
@Controller
public class SearchBorrowedBookController {
	
	@Autowired
    private UserProxy userProxy;
	
	@Autowired 
	private BorrowedBookProxy borrowedBookProxy;
	/**
	 * Methode request GET qui affiche la liste des borrowedBook de l'user identifé
	 * @param model afin d'ajouter l'user et les borrowedBook au model
	 * @return la page searchBorrowedBook
	 */
	@RequestMapping(value="/searchBorrowedBook", method = RequestMethod.GET)
	public String searchBorrowedBook(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByUsername(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		
		model.addAttribute("username", usernameString);
		
        List<BorrowedBookBean> userBorrowedbook = borrowedBookProxy.findAllByuser(user.getId()) ;  

        model.addAttribute("userBorrowedbook", userBorrowedbook);
      
		return "/searchBorrowedBook" ;
	
	}
	
	
	@RequestMapping(value="/searchBorrowedBook", method = RequestMethod.POST)
	public String searchBorrowedBook(ModelMap model,@RequestParam(name="bookId")int bookid){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByUsername(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();

		model.addAttribute("username", usernameString);
		
		borrowedBookProxy.extensionDateBorrowing(bookid);
        List<BorrowedBookBean> userBorrowedbook = borrowedBookProxy.findAllByuser(user.getId());
        userBorrowedbook.get(0).getDateBorrowing().toString();
        model.addAttribute("userBorrowedbook", userBorrowedbook);
        
		return "/searchBorrowedBook" ;
	}
}

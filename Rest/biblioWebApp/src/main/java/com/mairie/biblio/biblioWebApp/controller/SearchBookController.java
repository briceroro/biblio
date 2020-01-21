package com.mairie.biblio.biblioWebApp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mairie.biblio.biblioWebApp.model.BookBean;
import com.mairie.biblio.biblioWebApp.model.BookingBean;
import com.mairie.biblio.biblioWebApp.model.UserBean;
import com.mairie.biblio.biblioWebApp.proxies.BookProxy;
import com.mairie.biblio.biblioWebApp.proxies.BookingProxy;
import com.mairie.biblio.biblioWebApp.proxies.UserProxy;

/**
 * Controller servant a recuperer la page SearchBook
 * @author briceroro
 *
 */
@Controller
public class SearchBookController {
	
	@Autowired
    private UserProxy userProxy;
	
	@Autowired
	private BookProxy bookProxy;
	
	@Autowired 
	private BookingProxy bookingProxy;

	
	/**
	 * Methode request GET servant a recuperer la page SearchBook avec l'user identifé
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchBook", method = RequestMethod.GET)
	public String home(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		model.addAttribute("username", usernameString);
		
		return "searchBook";
	}
	
	/**
	 * Methode request POST servant a recuperer la page SearchBook avec l'user identifé et une liste de Book suivant le param rensigné
	 * @param model afin d'ajouter l'user et les books au model
	 * @param name correspondant au titre du book rechercher par l'user
	 * @return
	 */
	@RequestMapping(value="/searchBook", method = RequestMethod.POST)
	public String home(ModelMap model,@RequestParam(name="nameBook")String name){
		
		if(name  != null) {
			System.out.println("lol");
		}
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		model.addAttribute("username", usernameString);
		
		List<BookBean> bookByKeywords = bookProxy.findByKeyswordsTitle(name);
		model.addAttribute("booksKey", bookByKeywords);
		
		Date date = new Date();
		model.addAttribute("today", date);
	
        Boolean checkBooking = false;
		
		List<BookingBean> userBookingList = bookingProxy.findAllByUser(user.getId());
		for (int i =0; i < userBookingList.size(); i++) {
			for(int y = 0; y < bookByKeywords.size(); y++) {
				if(userBookingList.get(i).getBook().getId() == bookByKeywords.get(y).getId()) {
					checkBooking = true;
				}
			}	
		}
		model.addAttribute("checkBooking", checkBooking);
		return "searchBook";
	}
	
	
	@RequestMapping(value="/searchBookAfterBooking", method = RequestMethod.POST)
	public String searchBookAfterBooking(ModelMap model,@RequestParam(name="bookId")int bookId){
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByName(auth.getName());
		BookBean book = bookProxy.findById(bookId);
		String usernameString = user.getLastName() +" "+ user.getName();
		model.addAttribute("username", usernameString);
		
		BookingBean bookingBean ;
		BookingBean newBookingBean;
		
		try {
			bookingBean = new BookingBean(user, book);
			newBookingBean = bookingProxy.createBooking(bookingBean);
			
		} catch (Exception e) {
			String ErrorCreateBooking = "impossible de reserver le livre: "+book.getTitle()+" vous l'avez déjà réservé ou emprunter";
			model.addAttribute("ErrorCreateBooking", ErrorCreateBooking);

		}

		
		return "searchBook";
	}

}

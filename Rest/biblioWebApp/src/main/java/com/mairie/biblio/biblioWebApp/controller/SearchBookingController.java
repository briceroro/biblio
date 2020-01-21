
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

import com.mairie.biblio.biblioWebApp.model.BookingBean;
import com.mairie.biblio.biblioWebApp.model.UserBean;
import com.mairie.biblio.biblioWebApp.proxies.BookingProxy;
import com.mairie.biblio.biblioWebApp.proxies.UserProxy;


@Controller
public class SearchBookingController {

	@Autowired
    private UserProxy userProxy;
	
	@Autowired 
	private BookingProxy bookingProxy;
	/**
	 * methode Get servant a afficher les booking en fonction de luser identifié
	 * 
	 * @param model
	 * @return searchBooking
	 */
	@RequestMapping(value="/searchBooking", method = RequestMethod.GET)
	public String searchBooking(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		int userInt = user.getId();
		model.addAttribute("username", usernameString);
		
		List<BookingBean> listUserBooking = bookingProxy.findAllByUser(userInt);

		model.addAttribute("listUserBooking", listUserBooking);
		
		return "/searchBooking";
	}
	
	/**
	 * methode Post servant a supprimer un booking
	 * 
	 * @param model
	 * @param bookingid
	 * @return la page des booking apres la supression du booking sélectionné
	 */
	@RequestMapping(value="/searchBooking", method = RequestMethod.POST)
	public String searchBooking(ModelMap model,@RequestParam(name="bookingId")int bookingId){
		BookingBean booking = bookingProxy.findById(bookingId);
		String deleteBooking = "La réservation : "+booking.getBook().getTitle()+" est bien annulée";
		model.addAttribute("deleteBooking", deleteBooking);
		
		bookingProxy.deleteBooking(booking);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserBean user = userProxy.findByUsername(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		
		model.addAttribute("username", usernameString);
		
		List<BookingBean> listUserBooking = bookingProxy.findAllByUser(user.getId());

		model.addAttribute("listUserBooking", listUserBooking);
		

		return "/searchBooking";
	}
}

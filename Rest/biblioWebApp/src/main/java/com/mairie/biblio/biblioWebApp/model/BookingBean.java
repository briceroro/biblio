package com.mairie.biblio.biblioWebApp.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean servant un booking aprés l'avoir récuperer via le webservice
 * @author briceroro
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class BookingBean {

	private int id;
	
	private int priorityOrder;

	private Date maxDateBooking;

	private UserBean user;

	private BookBean book;
	
	public BookingBean( UserBean user, BookBean book) {
		this.user = user;
		this.book = book;	
	}
	
}

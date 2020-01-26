package com.mairie.biblio.biblioWebApp.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean servant un book aprés l'avoir récupéré via le webservice
 * @author briceroro
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class BookBean {
	
	private int id;
	
	private String title;
	
	private String description;
	
	private boolean dispo;
	
	private int nbrOfBook;
	
	private int nbrDispo;
	
	private Date dateAvalaible;
	
	private String author;
	
	private String category;
	
	private boolean reserve;
	
	private int nbrBooking;
	
	public BookBean(String title, String description, boolean dispo, int nbrOfBook, int nbrDispo, Date dateAvalaible,
			String author, String category, boolean reserve, int nbrBooking) {
		super();
		this.title = title;
		this.description = description;
		this.dispo = dispo;
		this.nbrOfBook = nbrOfBook;
		this.nbrDispo = nbrDispo;
		this.dateAvalaible = dateAvalaible;
		this.author = author;
		this.category = category;
		this.reserve = reserve;
		this.nbrBooking = nbrBooking;
	}


}

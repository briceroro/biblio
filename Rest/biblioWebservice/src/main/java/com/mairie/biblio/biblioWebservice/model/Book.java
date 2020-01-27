package com.mairie.biblio.biblioWebservice.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "book_id")
	private int id;
	
	@Column(unique = true)
	private String title;
	
	@Column(columnDefinition="text")
	private String description;
	
	private boolean dispo;
	
	private int nbrOfBook;
	
	private int nbrDispo;
	
	@Temporal(TemporalType.DATE)
	private Date dateAvalaible;
	
	private String author;
	
	private String category;
	
	private boolean reserve;
	
	private int nbrBooking;

	public Book(String title, String description, boolean dispo, int nbrOfBook, int nbrDispo, Date dateAvalaible,
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

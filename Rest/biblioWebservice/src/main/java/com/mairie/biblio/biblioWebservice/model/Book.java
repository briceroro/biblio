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
	
	
	public Book () {
	
	}

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

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateAvalaible() {
		return dateAvalaible;
	}

	public void setDateAvalaible(Date dateAvalaible) {
		this.dateAvalaible = dateAvalaible;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public int getNbrBooking() {
		return nbrBooking;
	}

	public void setNbrBooking(int nbrBooking) {
		this.nbrBooking = nbrBooking;
	}

	public int getNbrDispo() {
		return nbrDispo;
	}

	public void setNbrDispo(int nbrDispo) {
		this.nbrDispo = nbrDispo;
	}

	public int getNbrOfBook() {
		return nbrOfBook;
	}

	public void setNbrOfBook(int nbrOfBook) {
		this.nbrOfBook = nbrOfBook;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
}

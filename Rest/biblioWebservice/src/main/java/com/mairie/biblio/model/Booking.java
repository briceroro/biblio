package com.mairie.biblio.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "booking_id")
	private int id;
	
	private int priorityOrder;
	
	@Temporal(TemporalType.DATE)
	private Date maxDateBooking;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
    public Booking() {
		
	}
	
	public Booking(int priorityOrder, User user, Book book) {
		this.priorityOrder = priorityOrder;
		this.user = user;
		this.book = book;	
	}
	
	public int getPriorityOrder() {
		return priorityOrder;
	}

	public void setPriorityOrder(int priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public Date getMaxDateBooking() {
		return maxDateBooking;
	}

	public void setMaxDateBooking(Date maxDateBooking) {
		this.maxDateBooking = maxDateBooking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

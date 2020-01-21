package com.mairie.biblio.biblioWebApp.model;

import java.util.Date;

public class BookingBean {

	private int id;
	
	private int priorityOrder;

	private Date maxDateBooking;

	private UserBean user;

	private BookBean book;
	
    public BookingBean() {
		
	}
	
	public BookingBean( UserBean user, BookBean book) {
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

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

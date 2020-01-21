package com.mairie.biblio.biblioWebApp.model;

import java.util.Date;

public class BorrowedBookBean {

		private int id;
		
		private Boolean availableExtension;
		
		private Date dateBorrowing;
		
		private BookBean book;
		
		private UserBean user;
		
		public BorrowedBookBean () {
			
		}
		
		public BorrowedBookBean (Boolean availableExtension,Date dateBorrowing,BookBean book,UserBean user) {
			super();
			this.availableExtension = availableExtension;
			this.dateBorrowing = dateBorrowing;
			this.book = book;
			this.user = user;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Boolean getAvailableExtension() {
			return availableExtension;
		}

		public void setAvailableExtension(Boolean availableExtension) {
			this.availableExtension = availableExtension;
		}

		public Date getDateBorrowing() {
			return dateBorrowing;
		}

		public void setDateBorrowing(Date dateBorrowing) {
			this.dateBorrowing = dateBorrowing;
		}

		public BookBean getBook() {
			return book;
		}

		public void setBook(BookBean book) {
			this.book = book;
		}

		public UserBean getUser() {
			return user;
		}

		public void setUser(UserBean user) {
			this.user = user;
		}
	
}

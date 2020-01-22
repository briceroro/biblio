package com.mairie.biblio.biblioWebApp.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean servant un borrowedBook aprés l'avoir récuperer via le webservice
 * @author briceroro
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class BorrowedBookBean {

		private int id;
		
		private Boolean availableExtension;
		
		private Date dateBorrowing;
		
		private BookBean book;
		
		private UserBean user;
		

		public BorrowedBookBean (Boolean availableExtension,Date dateBorrowing,BookBean book,UserBean user) {
			super();
			this.availableExtension = availableExtension;
			this.dateBorrowing = dateBorrowing;
			this.book = book;
			this.user = user;
		}
	
}

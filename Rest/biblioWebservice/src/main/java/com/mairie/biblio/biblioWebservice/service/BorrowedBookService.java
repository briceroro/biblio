package com.mairie.biblio.biblioWebservice.service;

import java.util.Date;
import java.util.List;

import com.mairie.biblio.biblioWebservice.model.BorrowedBook;

public interface BorrowedBookService {
	
	BorrowedBook findById(int id);
	Iterable<BorrowedBook> findAll();
	List<BorrowedBook> findByUser(int id);
	List<BorrowedBook> findBorrowedBookNotReturned();
	void checkBooking(BorrowedBook borrowedBook);
	void setFalseAvailableExtension( int borrowedBookId);
	Date extensionDateBorrowing(int id);
	void createBorrowedBook(BorrowedBook borrowedBook);
	void updateBorrowedBook(BorrowedBook borrowedBook);
	void deleteBorrowedBook(int id);
}

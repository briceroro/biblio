package com.mairie.biblio.biblioWebservice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mairie.biblio.biblioWebservice.exceptions.TargetConflictExeption;
import com.mairie.biblio.biblioWebservice.exceptions.TargetUnknownException;
import com.mairie.biblio.biblioWebservice.model.Book;
import com.mairie.biblio.biblioWebservice.model.Booking;
import com.mairie.biblio.biblioWebservice.model.BorrowedBook;
import com.mairie.biblio.biblioWebservice.model.User;
import com.mairie.biblio.biblioWebservice.repository.BookRepository;
import com.mairie.biblio.biblioWebservice.repository.BookingRepository;
import com.mairie.biblio.biblioWebservice.repository.BorrowedBookRepository;
import com.mairie.biblio.biblioWebservice.repository.UserRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Service(value = "borrowedBookService")
public class BorrowedBookServiceImpl implements BorrowedBookService {
	
	@Autowired
	BorrowedBookRepository borrowedBookrepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public BorrowedBook findById(int id) {
		return borrowedBookrepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("BorrowedBook :"+id+" est introuvable/n'existe pas"));
	}

	@Override
	public Iterable<BorrowedBook> findAll() {
		return borrowedBookrepository.findAll();
	}
	
	@Override
	public List<BorrowedBook> findByUser(int id) {
		return borrowedBookrepository.findByUser_id(id);
	}

	@Override
	public void createBorrowedBook(BorrowedBook borrowedBook) {
		
		int userId = borrowedBook.getUser().getId();
		int bookId = borrowedBook.getBook().getId();

		User user = userRepository.findById(userId).orElseThrow(()
        		-> new TargetUnknownException("User :"+userId+" est introuvable/n'existe pas"));
		
		Book book = bookRepository.findById(bookId).orElseThrow(()
        		-> new TargetUnknownException("Book :"+bookId+" est introuvable/n'existe pas"));
		
		boolean CheckBorrowedBook = borrowedBookrepository.findByBook_id(bookId).isPresent();

		if(!CheckBorrowedBook) {
			Date newdate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(newdate);
			cal.add(Calendar.DATE, 28);
			
			book.setDispo(false);
			if(book.getDateAvalaible().after(cal.getTime())) {
				book.setDateAvalaible(cal.getTime());
			}
			
			this.checkBooking(borrowedBook);
			
			borrowedBook.setAvailableExtension(true);
			borrowedBook.setDateBorrowing(cal.getTime());
			
			borrowedBookrepository.save(borrowedBook);
		}else {
			throw new TargetConflictExeption("Le book :"+book.getTitle()+" est deja emprunter");
		}
	}

	@Override
	public void updateBorrowedBook(BorrowedBook borrowedBook) {
		BorrowedBook borrowedBookUpdate =borrowedBookrepository.findById(borrowedBook.getId()) .orElseThrow(()
        		-> new TargetUnknownException("Book :"+borrowedBook.getId()+" est introuvable/n'existe pas"));
	
		borrowedBookUpdate.setAvailableExtension(borrowedBook.getAvailableExtension());
		borrowedBookUpdate.setDateBorrowing(borrowedBook.getDateBorrowing());
		borrowedBookUpdate.setBook(borrowedBook.getBook());
		borrowedBookUpdate.setUser(borrowedBook.getUser());
		
		borrowedBookrepository.save(borrowedBookUpdate);
	}

	@Override
	public void deleteBorrowedBook(int id) {
		BorrowedBook borrowedBook = borrowedBookrepository.findById(id) .orElseThrow(()
        		-> new TargetUnknownException("Book :"+id+" est introuvable/n'existe pas"));
		
		Book book = bookRepository.findById(borrowedBook.getBook().getId()).orElseThrow(()
        		-> new TargetUnknownException("Book :"+borrowedBook.getBook().getId()+" est introuvable/n'existe pas"));

		if (!book.isReserve()) {
			book.setDispo(true);
			book.setDateAvalaible(new Date());
		}

		borrowedBookrepository.delete(borrowedBook);
		
	}

	@Override
	public List<BorrowedBook> findBorrowedBookNotReturned() {
		
		List<BorrowedBook> AllBorrowedBooks = (List<BorrowedBook>) borrowedBookrepository.findAll();
		List<BorrowedBook> BookNotReturned =  new ArrayList<BorrowedBook>();

			if(!AllBorrowedBooks.isEmpty()) {
				for(int i= 0; i< AllBorrowedBooks.size() ;i++) {
					Date date = new Date();
					if(AllBorrowedBooks.get(i).getDateBorrowing().compareTo(date) < 0) {
						this.setFalseAvailableExtension(AllBorrowedBooks.get(i).getId());
						BookNotReturned.add(AllBorrowedBooks.get(i));
					}
				}	
			}
		return BookNotReturned;
	}


	@Override
	public void checkBooking(BorrowedBook borrowedBook) {
	
		int userId = borrowedBook.getUser().getId();
		int bookId = borrowedBook.getBook().getId();
		
		List<Booking> userBooking = bookingRepository.findByUser_id(userId);

		if(!userBooking.isEmpty()) {
			for ( int i =0; i < userBooking.size(); i++) {
				if ( userBooking.get(i).getBook().getId() == bookId) {
					bookingRepository.delete(userBooking.get(i));
				}
			}
		}	
	}

	@Override
	public void setFalseAvailableExtension(int id) {
		
		BorrowedBook borrowedBook = borrowedBookrepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("BorrowedBook :"+id+" est introuvable/n'existe pas"));
		
		borrowedBook.setAvailableExtension(false);
		
		borrowedBookrepository.save(borrowedBook);
		
	}

	@Override
	public Date extensionDateBorrowing(int id) {
		BorrowedBook borrowedBook = borrowedBookrepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("BorrowedBook :"+id+" est introuvable/n'existe pas"));
		
		Book book = bookRepository.findById(borrowedBook.getBook().getId()).orElseThrow(()
        		-> new TargetUnknownException("Book :"+borrowedBook.getBook().getId()+" est introuvable/n'existe pas"));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(borrowedBook.getDateBorrowing());
		cal.add(Calendar.DATE, 28);
		
		borrowedBook.setDateBorrowing(cal.getTime());
		borrowedBook.setAvailableExtension(false);

		if(book.getDateAvalaible().after(cal.getTime())) {
			book.setDateAvalaible(cal.getTime());
		}

		borrowedBookrepository.save(borrowedBook);
		bookRepository.save(book);
		
		return borrowedBook.getDateBorrowing();
	}
}

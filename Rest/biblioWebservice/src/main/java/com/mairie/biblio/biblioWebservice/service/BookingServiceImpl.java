package com.mairie.biblio.biblioWebservice.service;

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
import com.mairie.biblio.biblioWebservice.repository.BookingRepository;


@Service(value="bookingService")
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BorrowedBookService borrowedBookService;

	@Override
	public Iterable<Booking> finAll() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> findAllByUser(int userId) {
		return bookingRepository.findByUser_id(userId);
	}

	@Override
	public Iterable<Booking> findAllByBook(int bookId) {
		
		return bookingRepository.findByBook_id(bookId);
	}
	
	@Override
	public Booking findById(int bookingId) {
		return bookingRepository.findById(bookingId).orElseThrow(()
        		-> new TargetUnknownException("booking :"+bookingId+" est introuvable/n'existe pas"));
	}

	@Override
	public void createBooking(Booking booking) {
		
		int userId = booking.getUser().getId();
		int bookId = booking.getBook().getId();
		
		Book book = bookService.findById(bookId);
		
		List<BorrowedBook> borrowedBookUserList = borrowedBookService.findByUser(userId);
		
		List<Booking> bookingList =  bookingRepository.findByUser_id(userId);
		
		for (int i = 0; i < borrowedBookUserList.size(); i++) {
		    if (borrowedBookUserList.get(i).getBook().getId() == bookId) {
		    throw new TargetConflictExeption("xxxxx :"+bookId+"xxxxx");
		    }
		}
		
		for (int i= 0; i < bookingList.size(); i++) {
			if(bookingList.get(i).getBook().getId() == bookId) {
				throw new TargetConflictExeption("xxxxx :"+bookId+"xxxxx");
			}
		}
		
		book.setNbrBooking(book.getNbrBooking()+1);
		book.setReserve(true);
		
	    booking.setPriorityOrder(book.getNbrBooking());

		bookingRepository.save(booking);
		bookService.updateBook(book);

	}

	@Override
	public void updateBooking(Booking booking) {

		Booking bookingUpdate = bookingRepository.findById(booking.getId()).orElseThrow(()
        		-> new TargetUnknownException("booking :"+booking.getId()+" est introuvable/n'existe pas"));
		
		bookingUpdate.setMaxDateBooking(booking.getMaxDateBooking());
		bookingUpdate.setPriorityOrder(booking.getPriorityOrder());
		
	}

	@Override
	public void deleteBooking(Booking booking) {
		int bookingId = booking.getId();
		int bookId = booking.getBook().getId();
		
		Book book = bookService.findById(bookId);
		
		book.setNbrBooking(book.getNbrBooking()-1);
		if (book.getNbrBooking() == 0) {
			book.setReserve(false);
		}
		
		bookingRepository.findById(bookingId).orElseThrow(()
        		-> new TargetUnknownException("booking :"+booking.getId()+" est introuvable/n'existe pas"));
		
		bookingRepository.delete(booking);
		bookService.updateBook(book);
	}

	@Override
	public void initDateLimiteBooking(int id) {
		Booking booking = bookingRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("booking :"+id+" est introuvable/n'existe pas"));
		
		Date newdate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(newdate);
		cal.add(Calendar.DATE, 2);
		
		booking.setMaxDateBooking(cal.getTime());
		bookingRepository.save(booking);
		
	}

	

}

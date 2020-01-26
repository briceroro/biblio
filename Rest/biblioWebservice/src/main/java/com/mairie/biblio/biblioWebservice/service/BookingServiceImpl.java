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
import lombok.extern.slf4j.Slf4j;

/**
 * class servant a implémenter le metier de la class booking
 * @author briceroro
 *
 */
@Slf4j
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

	/**
	 * methode servant a retouner la liste  des booking
	 * @return un iterable de  la totalité des booking
	 */
	@Override
	public Iterable<Booking> finAll() {
		return bookingRepository.findAll();
	}

	/**
	 * methode servant a retourner la liste des booking d'un user
	 * @param id de l'user
	 * @return la liste des booking d'un user
	 */
	@Override
	public List<Booking> findAllByUser(int userId) {
		return bookingRepository.findByUser_id(userId);
	}

	/**
	 * methode servant a retourner un iterable des booking par book
	 * @param id du book
	 * @return la liste des booking du book 
	 */
	@Override
	public Iterable<Booking> findAllByBook(int bookId) {
		return bookingRepository.findByBook_id(bookId);
	}
	
	/**
	 * methode servant a récupéré un booking par son id
	 * @param id du booking
	 * @return une exception ou le booking en param
	 */
	@Override
	public Booking findById(int bookingId) {
		return bookingRepository.findById(bookingId).orElseThrow(()
        		-> new TargetUnknownException("booking :"+bookingId+" est introuvable/n'existe pas"));
	}

	/**
	 * methode servant a creer un booking 
	 * @param le booking a inscrire en bdd
	 * @return le booking créé 
	 */
	@Override
	public Booking createBooking(Booking booking) {
		
		int userId = booking.getUser().getId();
		int bookId = booking.getBook().getId();
		
		Book book = bookService.findById(bookId);
		
		List<BorrowedBook> borrowedBookUserList = borrowedBookService.findByUser(userId);
		
		List<Booking> bookingList =  bookingRepository.findByUser_id(userId);
		
		for (int i = 0; i < borrowedBookUserList.size(); i++) {
		    if (borrowedBookUserList.get(i).getBook().getId() == bookId) {
		        throw new TargetConflictExeption("le book :"+bookId+"est deja emprunté par l'user: "+userId);
		    }
		}
		
		for (int i= 0; i < bookingList.size(); i++) {
			if(bookingList.get(i).getBook().getId() == bookId) {
				throw new TargetConflictExeption("le book :"+bookId+" est deja réservé par l'user :"+userId);
			
			}
		}
		
		book.setNbrBooking(book.getNbrBooking()+1);
		book.setReserve(true);
		
	    booking.setPriorityOrder(book.getNbrBooking());

		bookingRepository.save(booking);
		bookService.updateBook(book);
	    
		log.info("L'user: "+userId+" a réservé le book: "+bookId);
		return booking;

	}

	/**
	 * methode servant a modifier un booking 
	 * @param booking a modifier
	 * @return le booking modifié
	 */
	@Override
	public Booking updateBooking(Booking booking) {

		Booking bookingUpdate = bookingRepository.findById(booking.getId()).orElseThrow(()
        		-> new TargetUnknownException("booking :"+booking.getId()+" est introuvable/n'existe pas"));
		
		bookingUpdate.setMaxDateBooking(booking.getMaxDateBooking());
		bookingUpdate.setPriorityOrder(booking.getPriorityOrder());
		
		bookingRepository.save(bookingUpdate);
	
		log.info(" le booking: "+booking.getId()+" a bien été modifié" );
		return booking;
		
		
	}

	/**
	 * methode servant a supprimer  un booking
	 * @param le booking a supprimer
	 * 
	 */
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
		
		log.info("le booking :"+bookingId+" a été supprimé");
	}
	

	/**
	 * methode servant a initialiser la date limite d'un booking
	 * @param id du booking a modifier
	 */
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
		
		log.info("la date du booking:"+booking.getId()+" a bien été initialisée");
	}
}

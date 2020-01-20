package com.mairie.biblio.biblioWebservice.service;



import com.mairie.biblio.biblioWebservice.model.Booking;

public interface BookingService {

	Iterable<Booking> finAll();
	Iterable<Booking> findAllByUser(int userId);
	Iterable<Booking> findAllByBook(int bookId);
	Booking findById(int id);
	Booking createBooking(Booking booking);
	Booking updateBooking(Booking booking);
	void deleteBooking(Booking booking);
	void initDateLimiteBooking(int bookingId);
	
}

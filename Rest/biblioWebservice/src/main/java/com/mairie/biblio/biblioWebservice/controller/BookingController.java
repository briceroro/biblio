package com.mairie.biblio.biblioWebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mairie.biblio.biblioWebservice.model.Booking;
import com.mairie.biblio.biblioWebservice.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired BookingService bookingService;
	
	@GetMapping(value="/booking/all")
	public Iterable<Booking> findAll() {
		return bookingService.finAll();
	}
	
	@GetMapping(value="/booking/all/user/{userId}")
	public Iterable<Booking> findAllByUser(@PathVariable int userId) {
		return bookingService.findAllByUser(userId);
	}
	
	@GetMapping(value="/booking/all/book/{bookId}")
	public Iterable<Booking> findAllByBook(@PathVariable int bookId) {
		return bookingService.findAllByBook(bookId);
	}
	
	@GetMapping(value="/booking/id/{id}")
	public Iterable<Booking> findById(@PathVariable int bookId) {
		return bookingService.findAllByBook(bookId);
		
	}
	
	@PostMapping(value="/booking")
	public void createBooking(@RequestBody Booking booking) {
		bookingService.createBooking(booking);
	}
	
	@PutMapping(value="/booking")
	public void updateBooking(@RequestBody Booking booking) {
		bookingService.updateBooking(booking);
	}
	
	@PutMapping(value="/booking/datelimite")
	public void initDateLimiteBooking(@RequestBody int bookingId) {
		bookingService.initDateLimiteBooking(bookingId);
	}
	
	@DeleteMapping(value="/booking")
	public void deleteBooking(@RequestBody Booking booking) {
		bookingService.deleteBooking(booking);
	}
}

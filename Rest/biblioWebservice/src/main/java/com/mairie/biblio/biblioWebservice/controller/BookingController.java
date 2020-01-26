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

import io.swagger.annotations.ApiOperation;


@RestController
public class BookingController {
	
	@Autowired BookingService bookingService;
	
	@ApiOperation(value = "rechercher tous les booking")
	@GetMapping(value="/booking/all")
	public Iterable<Booking> findAll() {
		return bookingService.finAll();
	}
	
	@ApiOperation(value = "rechercher tous les booking d'un user")
	@GetMapping(value="/booking/all/user/{userId}")
	public Iterable<Booking> findAllByUser(@PathVariable int userId) {
		return bookingService.findAllByUser(userId);
	}
	
	@ApiOperation(value = "rechercher tous les booking d'un livre")
	@GetMapping(value="/booking/all/book/{bookId}")
	public Iterable<Booking> findAllByBook(@PathVariable int bookId) {
		return bookingService.findAllByBook(bookId);
	}
	
	@ApiOperation(value = "rechercher un booking par son id")
	@GetMapping(value="/booking/id/{id}")
	public Booking findById(@PathVariable int id) {
		return bookingService.findById(id);
		
	}
	
	@ApiOperation(value = "créer un booking")
	@PostMapping(value="/booking")
	public Booking createBooking(@RequestBody Booking booking) {
		bookingService.createBooking(booking);
		return booking;
	}
	
	@ApiOperation(value = "modifier un booking")
	@PutMapping(value="/booking")
	public void updateBooking(@RequestBody Booking booking) {
		bookingService.updateBooking(booking);
	}
	
	@ApiOperation(value = "initialiser la date max pour récupérer un booking")
	@PutMapping(value="/booking/datelimite")
	public void initDateLimiteBooking(@RequestBody int bookingId) {
		bookingService.initDateLimiteBooking(bookingId);
	}
	
	@ApiOperation(value = "supprimer un booking")
	@DeleteMapping(value="/booking")
	public void deleteBooking(@RequestBody Booking booking) {
		bookingService.deleteBooking(booking);
	}
}

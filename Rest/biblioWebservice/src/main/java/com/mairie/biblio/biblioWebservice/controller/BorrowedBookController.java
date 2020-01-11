package com.mairie.biblio.biblioWebservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mairie.biblio.biblioWebservice.model.BorrowedBook;
import com.mairie.biblio.biblioWebservice.service.BorrowedBookService;

@RestController
public class BorrowedBookController {
	
	@Autowired
	BorrowedBookService borrowedBookService;
	
	@GetMapping(value="/borrowedbook/all")
	public Iterable<BorrowedBook> findAll(){
		return borrowedBookService.findAll();
		
	}
	
	@GetMapping(value="/borrowedbook/all/user/{id}")
	public List<BorrowedBook> findAllser(@PathVariable int id){
		return borrowedBookService.findByUser(id);
		
	}
	@GetMapping(value="/borrowedbook/notreturned")
	public List<BorrowedBook> findBorrowedBookNotReturned(){
		return borrowedBookService.findBorrowedBookNotReturned();
		
	}
	
	@GetMapping(value="/borrowedbook/user/{id}")
	public BorrowedBook findById(@PathVariable int id) {
		return borrowedBookService.findById(id);
		
	}
	
	@PostMapping(value="/borrowedbook/checkbooking")
	public void checkBooking(@RequestBody BorrowedBook borrowedBook) {
		borrowedBookService.checkBooking(borrowedBook);
	}
	
	@PostMapping(value="/borrowedbook/setfalseavailableextension")
	public void setFalseAvailableExtension(@RequestBody int borrowedBookId) {
		borrowedBookService.setFalseAvailableExtension(borrowedBookId);
	}
	
	@PostMapping(value="/borrowedbook/extensiondate")
	public Date extensionDateBorrowing(@RequestBody int id) {
		return borrowedBookService.extensionDateBorrowing(id);
	}
	
	@PostMapping(value="/borrowedbook")
	public void createBorrowedBook(@RequestBody BorrowedBook borrowedBook) {	
		borrowedBookService.createBorrowedBook(borrowedBook);	
	}
	
	@PutMapping(value="/borrowedbook")
	public void updateBorrowedBook(@RequestBody BorrowedBook borrowedBook) {
		borrowedBookService.updateBorrowedBook(borrowedBook);
		
	}
	
	@DeleteMapping(value="/borrowedbook/{id}")
	public void deleteBorrowedBook(@PathVariable int id){
		borrowedBookService.deleteBorrowedBook(id);
	}


}

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

import io.swagger.annotations.ApiOperation;

@RestController
public class BorrowedBookController {
	
	@Autowired
	BorrowedBookService borrowedBookService;
	
	@ApiOperation(value = "rechercher tous les borrowedBook")
	@GetMapping(value="/borrowedbook/all")
	public Iterable<BorrowedBook> findAll(){
		return borrowedBookService.findAll();
		
	}
	
	@ApiOperation(value = "rechercher tous les borrowedBook d'un user")
	@GetMapping(value="/borrowedbook/all/user/{id}")
	public List<BorrowedBook> findAllser(@PathVariable int id){
		return borrowedBookService.findByUser(id);
		
	}
	
	@ApiOperation(value = "rechercher tous les borrowedBook non retournés")
	@GetMapping(value="/borrowedbook/notreturned")
	public List<BorrowedBook> findBorrowedBookNotReturned(){
		return borrowedBookService.findBorrowedBookNotReturned();
		
	}
	
	@ApiOperation(value = "rechercher un borrowedBoo par son id")
	@GetMapping(value="/borrowedbook/user/{id}")
	public BorrowedBook findById(@PathVariable int id) {
		return borrowedBookService.findById(id);
		
	}
	
	@ApiOperation(value = "verifier si un user  pas deja emprunté un book")
	@PostMapping(value="/borrowedbook/checkbooking")
	public void checkBooking(@RequestBody BorrowedBook borrowedBook) {
		borrowedBookService.checkBooking(borrowedBook);
	}
	
	@ApiOperation(value = "rendre impossible l'extension de la date retour d'un borrowedBook")
	@PostMapping(value="/borrowedbook/setfalseavailableextension")
	public void setFalseAvailableExtension(@RequestBody int borrowedBookId) {
		borrowedBookService.setFalseAvailableExtension(borrowedBookId);
	}
	
	@ApiOperation(value = "étendre la date de retour d'un borrowedBook")
	@PostMapping(value="/borrowedbook/extensiondate")
	public Date extensionDateBorrowing(@RequestBody int id) {
		return borrowedBookService.extensionDateBorrowing(id);
	}
	
	@ApiOperation(value = "créer un borrowedBook")
	@PostMapping(value="/borrowedbook")
	public void createBorrowedBook(@RequestBody BorrowedBook borrowedBook) {	
		borrowedBookService.createBorrowedBook(borrowedBook);	
	}
	
	@ApiOperation(value = "modifier un borrowedBook")
	@PutMapping(value="/borrowedbook")
	public void updateBorrowedBook(@RequestBody BorrowedBook borrowedBook) {
		borrowedBookService.updateBorrowedBook(borrowedBook);
		
	}
	
	@ApiOperation(value = "supprimer un borrowedBook")
	@DeleteMapping(value="/borrowedbook/{id}")
	public void deleteBorrowedBook(@PathVariable int id){
		borrowedBookService.deleteBorrowedBook(id);
	}


}

package com.mairie.biblio.biblioWebservice.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mairie.biblio.biblioWebservice.model.Book;
import com.mairie.biblio.biblioWebservice.repository.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired BookRepository bookrepository;
	
	@GetMapping(value="/Book/{id}")
	public Book findById(@PathVariable int id) {
		return bookrepository.findBookById(id);
	}

}

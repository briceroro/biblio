package com.mairie.biblio.biblioWebservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mairie.biblio.biblioWebservice.model.Book;
import com.mairie.biblio.biblioWebservice.service.BookService;
import com.mairie.biblio.biblioWebservice.service.BookingServiceImpl;

import lombok.extern.log4j.Log4j;
@RestController
public class BookController {
	
	@Autowired 
	BookService bookService;
	
	@GetMapping(value="/book/all")
	public Iterable<Book> findAll() {
		return bookService.findAll();
	}
	
	@GetMapping(value="/book/all/bykeyswords/{mc}")
	public List<Book> findByKeyswordsTitle(@PathVariable String mc) {
		return bookService.findBookByKeywordsTitle(mc);
	}
	
	@GetMapping(value="/book/all/author/{author}")
	public List<Book> findByAuthor(@PathVariable String author) {
		return bookService.findBookByAuthor(author);
	}
	
	@GetMapping(value="/book/all/category/{category}")
	public List<Book> findByCategory(@PathVariable String category) {
		return bookService.findBookByAuthor(category);
	}
	
	@GetMapping(value="/book/id/{id}")
	public Book findById(@PathVariable int id) {
		return bookService.findById(id);
	}
	
	@GetMapping(value="/book/title/{title}")
	public Book findById(@PathVariable String title) {
		return bookService.findByTitle(title);
	}
	
	@PostMapping(value="/book")
	public void createBook(@RequestBody Book book) {
		bookService.createBook(book);
		
	}
	
	@PutMapping(value="/book")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		
	}
	
	@DeleteMapping(value="/book/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
	
}

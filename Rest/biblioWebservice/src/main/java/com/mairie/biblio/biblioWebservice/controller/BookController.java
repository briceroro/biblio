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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
public class BookController {
	
	@Autowired 
	BookService bookService;
	
	@ApiOperation(value = "rechercher tous les livres")
	@GetMapping(value="/book/all")
	public Iterable<Book> findAll() {
		return bookService.findAll();
	}
	
	@ApiOperation(value = "rechercher les livres contenant le mot clé")
	@GetMapping(value="/book/all/bykeyswords/{mc}")
	public List<Book> findByKeyswordsTitle(@PathVariable String mc) {
		return bookService.findBookByKeywordsTitle(mc);
	}
	
	@ApiOperation(value = "rechercher les livres par autheur")
	@GetMapping(value="/book/all/author/{author}")
	public List<Book> findByAuthor(@PathVariable String author) {
		return bookService.findBookByAuthor(author);
	}
	
	@ApiOperation(value = "rechercher les livres par catégorie")
	@GetMapping(value="/book/all/category/{category}")
	public List<Book> findByCategory(@PathVariable String category) {
		return bookService.findBookByAuthor(category);
	}
	
	@ApiOperation(value = "rechercher un livre par son id")
	@GetMapping(value="/book/id/{id}")
	public Book findById(@PathVariable int id) {
		return bookService.findById(id);
	}
	
	@ApiOperation(value = "rechercher un livre par son titre")
	@GetMapping(value="/book/title/{title}")
	public Book findByTitle(@PathVariable String title) {
		return bookService.findByTitle(title);
	}
	
	@ApiOperation(value = "créer un livre en BDD")
	@PostMapping(value="/book")
	public void createBook(@RequestBody Book book) {
		bookService.createBook(book);
		
	}
	
	@ApiOperation(value = "modifier un livre en BDD")
	@PutMapping(value="/book")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		
	}
	
	@ApiOperation(value = "supprimmer un livre en BDD")
	@DeleteMapping(value="/book/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
	
}

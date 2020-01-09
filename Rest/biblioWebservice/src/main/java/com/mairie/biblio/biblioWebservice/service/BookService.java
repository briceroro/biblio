package com.mairie.biblio.biblioWebservice.service;

import java.util.List;

import com.mairie.biblio.biblioWebservice.model.Book;

public interface BookService {

	Book findByTitle(String title);
	Book findById(int id);
	Iterable<Book> findAll();
	List<Book> findBookByKeywordsTitle(String mc);
	List<Book> findBookByAuthor(String author);
	List<Book> findBookByCategory(String category);
    void createBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
	
	
}

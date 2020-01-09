package com.mairie.biblio.biblioWebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mairie.biblio.biblioWebservice.exceptions.TargetConflictExeption;
import com.mairie.biblio.biblioWebservice.exceptions.TargetUnknownException;
import com.mairie.biblio.biblioWebservice.model.Book;
import com.mairie.biblio.biblioWebservice.repository.BookRepository;

@Service(value = "bookService")
public class BookserviceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book findByTitle(String title) {
		return bookRepository.findBytitle(title).orElseThrow(()
        		-> new TargetUnknownException("Book :"+title+" est introuvable/n'existe pas"));
	}

	@Override
	public Book findById(int id) {
		return bookRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("Book :"+id+" est introuvable/n'existe pas"));
	}

	@Override
	public List<Book> findBookByKeywordsTitle(String mc) {
		return bookRepository.findBookByKeywordsTitle(mc);
	}

	@Override
	public List<Book> findBookByAuthor(String author) {
		return bookRepository.findBookByAuthor(author);
	}

	@Override
	public List<Book> findBookByCategory(String category) {
		return bookRepository.findBookByCategory(category);
	}

	@Override
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void createBook(Book book) {
		if(bookRepository.findBytitle(book.getTitle()).isPresent() == true) {
    		throw new TargetConflictExeption("Book :"+book.getTitle()+" existe deja");
    	}
    	else {
    		bookRepository.save(book);	
           }	
		
	}

	@Override
	public void updateBook(Book book) {
		Book bookUpdateBook = bookRepository.findById(book.getId()).orElseThrow(()
        		-> new TargetUnknownException("Book :"+book.getId()+" est introuvable/n'existe pas"));

		bookUpdateBook.setTitle(book.getTitle());	
		bookUpdateBook.setDescription(book.getDescription());
		bookUpdateBook.setDispo(book.isDispo());
		bookUpdateBook.setNbrOfBook(book.getNbrOfBook());
		bookUpdateBook.setNbrDispo(book.getNbrDispo());
		bookUpdateBook.setDateAvalaible(book.getDateAvalaible());
		bookUpdateBook.setAuthor(book.getAuthor());
		bookUpdateBook.setCategory(book.getCategory());
		bookUpdateBook.setReserve(book.isReserve());
		bookUpdateBook.setNbrBooking(book.getNbrBooking());
		
		bookRepository.save(bookUpdateBook);
	}

	@Override
	public void deleteBook(int id) {
		Book book = bookRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("Book :"+id+" est introuvable/n'existe pas"));
		
		bookRepository.delete(book);
		
	}

}

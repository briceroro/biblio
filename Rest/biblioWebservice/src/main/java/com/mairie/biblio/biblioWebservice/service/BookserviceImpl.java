package com.mairie.biblio.biblioWebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mairie.biblio.biblioWebservice.exceptions.TargetConflictExeption;
import com.mairie.biblio.biblioWebservice.exceptions.TargetUnknownException;
import com.mairie.biblio.biblioWebservice.model.Book;
import com.mairie.biblio.biblioWebservice.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * class servant a implémenter le metier de la class book
 * @author briceroro
 *
 */
@Slf4j
@Service(value = "bookService")
public class BookserviceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	/**
	 * methode servant a retourner un book par son titre
	 * @param le titre du book a chercher
	 * @return le book recherché
	 */
	@Override
	public Book findByTitle(String title) {
		return bookRepository.findBytitle(title).orElseThrow(()
        		-> new TargetUnknownException("Book :"+title+" est introuvable/n'existe pas"));
	}

	/**
	 * methode servant a retourner un book par son id
	 * @param id du book 
	 * @return le book rechercher
	 */
	@Override
	public Book findById(int id) {
		return bookRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("Book :"+id+" est introuvable/n'existe pas"));
	}

	/**
	 * methode servant a retourner une liste de book contenant un mot clé
	 * @param mot clé 
	 * @return la liste des book contenant le mot clé
	 */
	@Override
	public List<Book> findBookByKeywordsTitle(String mc) {
		return bookRepository.findBookByKeywordsTitle(mc);
	}

	/**
	 * methode servant retourner une liste de book par autheur
	 * @param autheur des book a chercher
	 * @return la liste des book de l'autheur en param
	 */
	@Override
	public List<Book> findBookByAuthor(String author) {
		return bookRepository.findBookByAuthor(author);
	}

	/**
	 * methode servant a retourner une liste de book par catégorie
	 * @param categorie des book a chercher
	 * @return la liste des book de la categorie en param
	 */
	@Override
	public List<Book> findBookByCategory(String category) {
		return bookRepository.findBookByCategory(category);
	}

	/**
	 * methode servant a retourner un iterable de la totalité des book
	 * @return une liste contenant la totalité des book
	 */
	@Override
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	/**
	 * methode servant a créer un book
	 * @param le book a créer
	 * @return le book créer
	 */
	@Override
	public void createBook(Book book) {
		if(bookRepository.findBytitle(book.getTitle()).isPresent() == true) {
    		throw new TargetConflictExeption("Book :"+book.getTitle()+" existe deja");
    	}
    	else {
    		bookRepository.save(book);	
    		log.info("le book: "+book.getTitle()+" a bien été crée");
           }	
		
	}

	/**
	 * methode servant a modifier un book
	 * 
	 * @param book a modifier
	 * @return le book modifier
	 */
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
		log.info("le book: "+book.getId()+" a été modifié");
	}

	/**
	 * methode servant a supprimer un book
	 * @param l'id du book a supprimer
	 */
	@Override
	public void deleteBook(int id) {
		Book book = bookRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("Book :"+id+" est introuvable/n'existe pas"));
		
		bookRepository.delete(book);
		log.info("le book: "+book.getTitle()+" a bien été supprimé");
		
	}

}

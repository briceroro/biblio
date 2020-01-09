package com.mairie.biblio.biblioWebservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mairie.biblio.biblioWebservice.model.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
	
   Optional<Book> findBytitle(String title);
   
   @Query("select b from Book b where b.title LIKE %?1%") 
   List<Book> findBookByKeywordsTitle(@Param("title")String mc);
  
   List<Book> findBookByAuthor(String author);
	
   List<Book> findBookByCategory(String category);
   
}

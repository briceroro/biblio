package com.mairie.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mairie.biblio.model.Book;


public interface BookRepository extends CrudRepository<Book, Long>{
	
   Book findBookBytitle(String title);
	
   Book findBookById(int id);
	
   @Query("select b from Book b where b.title LIKE %?1%") 
   List<Book> findBookByKeywordsTitle(@Param("title")String mc);
  
   List<Book> findBookByAuthor(String author);
	
   List<Book> findBookByCategory(String category);
   
   @Query("from Book") 
   List<Book> findAllbook();
   
}

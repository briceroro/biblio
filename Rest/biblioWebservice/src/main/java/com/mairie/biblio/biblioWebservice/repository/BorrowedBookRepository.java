package com.mairie.biblio.biblioWebservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.biblioWebservice.model.BorrowedBook;


public interface BorrowedBookRepository extends CrudRepository<BorrowedBook, Long>{
	
   List<BorrowedBook> findByUser_id(int id);
	
   BorrowedBook findById(int id);
	
   List<BorrowedBook> findAll();

}

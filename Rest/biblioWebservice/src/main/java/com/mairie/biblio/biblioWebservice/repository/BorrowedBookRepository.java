package com.mairie.biblio.biblioWebservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.biblioWebservice.model.BorrowedBook;


public interface BorrowedBookRepository extends CrudRepository<BorrowedBook, Integer>{
	
   List<BorrowedBook> findByUser_id(int id);
   Optional<BorrowedBook> findByBook_id(int id);

}

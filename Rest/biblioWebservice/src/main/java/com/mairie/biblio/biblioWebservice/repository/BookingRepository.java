package com.mairie.biblio.biblioWebservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.biblioWebservice.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{
	
    Booking findById(int id);

	List<Booking> findByUser_id(int id);

	@Query("from Booking") 
	List<Booking> findAllbooking();

	List<Booking> findByBook_id(int bookId);

}

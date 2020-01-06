package com.mairie.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{
	
    Booking findById(int id);

	List<Booking> findByUser_id(int id);

	@Query("from Booking") 
	List<Booking> findAllbooking();

	List<Booking> findByBook_id(int bookId);

}

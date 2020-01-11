package com.mairie.biblio.biblioWebservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.biblioWebservice.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{
	
	public List<Booking> findByUser_id(int userId);
	public List<Booking> findByBook_id(int bookId);
	

}

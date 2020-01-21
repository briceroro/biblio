package com.mairie.biblio.biblioWebApp.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mairie.biblio.biblioWebApp.model.BookingBean;

@FeignClient(name = "microservice-biblio", url = "localhost:8080")
public interface BookingProxy {

	@GetMapping(value="/booking/all/user/{userId}")
	List<BookingBean> findAllByUser(@PathVariable int userId);
	
	@GetMapping(value="/booking/all/book/{bookId}")
	Iterable<BookingBean> findAllByBook(@PathVariable int bookId);
	
	@GetMapping(value="/booking/id/{id}")
	public BookingBean findById(@PathVariable int id) ;
	
	@PostMapping(value="/booking")
	BookingBean createBooking(@RequestBody BookingBean booking);
	
	@DeleteMapping(value="/booking")
	public void deleteBooking(@RequestBody BookingBean booking);

}

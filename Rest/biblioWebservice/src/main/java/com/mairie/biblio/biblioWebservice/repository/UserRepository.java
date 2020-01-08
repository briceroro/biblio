package com.mairie.biblio.biblioWebservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.biblioWebservice.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);

}

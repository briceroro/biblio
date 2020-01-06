package com.mairie.biblio.repository;

import org.springframework.data.repository.CrudRepository;

import com.mairie.biblio.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
	User findById(int id);

}

package com.mairie.biblio.biblioWebservice.service;

import com.mairie.biblio.biblioWebservice.model.User;

public interface UserService {
	
	Iterable<User> findAll();
	User findByUsername(String username);
	User findByName(String name);
	User findUserById(int id);
	void createUser(User user);
	void updateEmployee(User user);
	void deleteUser(int id);

}

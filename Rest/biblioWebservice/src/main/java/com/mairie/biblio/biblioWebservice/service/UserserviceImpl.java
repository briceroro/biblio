package com.mairie.biblio.biblioWebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mairie.biblio.biblioWebservice.exceptions.TargetConflictExeption;
import com.mairie.biblio.biblioWebservice.exceptions.TargetUnknownException;
import com.mairie.biblio.biblioWebservice.model.User;
import com.mairie.biblio.biblioWebservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "userService")
public class UserserviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(()
        		-> new TargetUnknownException("User :"+username+" est introuvable/n'existe pas"));
	}
	
	@Override
	public User findByName(String name) {
		return userRepository.findByName(name).orElseThrow(()
        		-> new TargetUnknownException("User :"+name+" est introuvable/n'existe pas"));
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("User :"+id+" est introuvable/n'existe pas"));
	}

	@Override
	public void createUser(User user) {
		if(userRepository.findByUsername(user.getName()).isPresent() == true) {
    		throw new TargetConflictExeption("User :"+user.getName()+" existe deja");
    	}
    	else {
    		userRepository.save(user);	
    		log.info("L'user: "+user.getName()+" a été crée");
           }	
	}

	@Override
	public void updateEmployee(User user) {
		User userUpdate = userRepository.findById(user.getId()).orElseThrow(()
        		-> new TargetUnknownException("User :"+user.getId()+" est introuvable/n'existe pas impossible de le modifier"));
    	 
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setName(user.getName());
        userUpdate.setActive(user.isActive());
        userUpdate.setRole(user.getRole());
  	
         userRepository.save(userUpdate);
         log.info("L'user: "+user.getName()+" a été modifié");
		
	}

	@Override
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("User :"+id+" est introuvable/n'existe pas impossible de le supprimer"));
    	
    	userRepository.delete(user);
    	log.info("L'user: "+user.getName()+" a été supprimé");
		
	}

}

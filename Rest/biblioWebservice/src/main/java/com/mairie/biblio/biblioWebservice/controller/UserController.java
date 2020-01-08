package com.mairie.biblio.biblioWebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mairie.biblio.biblioWebservice.exceptions.TargetConflictExeption;
import com.mairie.biblio.biblioWebservice.exceptions.TargetUnknownException;
import com.mairie.biblio.biblioWebservice.model.User;
import com.mairie.biblio.biblioWebservice.repository.UserRepository;
import com.mairie.biblio.biblioWebservice.service.UserService;

@RestController
public class UserController{
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/user/all")
	public Iterable<User> findAll(){
		return userService.findAll();
		
	}
	
    @GetMapping(value="/user/username/{username}")
    public  User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }
    
    @GetMapping(value="/UserById/{id}")
    public  User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
   
    @PostMapping(value="/User")
    public void createUser(@RequestBody User user) {
    	userService.createUser(user);
    }
    
    @PutMapping("/User")
    public void updateEmployee(@RequestBody User user) {	
    	userService.updateEmployee(user);
    }
    
    @DeleteMapping(value="/User/{id}")
    public void deleteUser(@PathVariable int id) {
    	userService.deleteUser(id);
    }
    
}
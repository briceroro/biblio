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

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController{
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "rechercher tous les user")
	@GetMapping(value="/user/all")
	public Iterable<User> findAll(){
		return userService.findAll();
		
	}
	
	@ApiOperation(value = "rechercher un user par son username")
    @GetMapping(value="/user/username/{username}")
    public  User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }
    
	@ApiOperation(value = "rechercher un user par son nom")
    @GetMapping(value="/user/name/{name}")
    public  User findByName(@PathVariable String name){
        return userService.findByUsername(name);
    }
    
	@ApiOperation(value = "rechercher un user par son id")
    @GetMapping(value="/user/id/{id}")
    public  User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
   
	@ApiOperation(value = "créer un user")
    @PostMapping(value="/user")
    public void createUser(@RequestBody User user) {
    	userService.createUser(user);
    }
    
	@ApiOperation(value = "modifier un user")
    @PutMapping("/user")
    public void updateEmployee(@RequestBody User user) {	
    	userService.updateUser(user);
    }
    
	@ApiOperation(value = "supprimer un user")
    @DeleteMapping(value="/user/{id}")
    public void deleteUser(@PathVariable int id) {
    	userService.deleteUser(id);
    }
    
}
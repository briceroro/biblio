package com.mairie.biblio.biblioWebservice.restController;

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

@RestController
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;
	
    @GetMapping(value="/UserByUsername/{username}")
    public  User findByUsername(@PathVariable String username){
        return userRepository.findByUsername(username).orElseThrow(()
        		-> new TargetUnknownException("User :"+username+" est introuvable/n'existe pas"));
    }
    
    @GetMapping(value="/UserById/{id}")
    public  User findUserById(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("User :"+id+" est introuvable/n'existe pas"));
    }
   
    @PostMapping(value="/User")
    public void createUser(@RequestBody User user) {
    	if(userRepository.findByUsername(user.getUserName()).isPresent() == true) {
    		throw new TargetConflictExeption("User :"+user.getUserName()+" existe deja");
    	}
    	else {
    		userRepository.save(user);	
           }
    }
    
    @PutMapping("/User")
    public void updateEmployee(@RequestBody User user) {	
    	User userUpdate = userRepository.findById(user.getId()).orElseThrow(()
        		-> new TargetUnknownException("User :"+user.getId()+" est introuvable/n'existe pas impossible de le modifier"));
    	 
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setUserName(user.getUserName());
        userUpdate.setActive(user.isActive());
        userUpdate.setRole(user.getRole());
  	
         userRepository.save(userUpdate);
    }
    
    @DeleteMapping(value="/User/{id}")
    public void deleteUser(@PathVariable int id) {
    	User user = userRepository.findById(id).orElseThrow(()
        		-> new TargetUnknownException("User :"+id+" est introuvable/n'existe pas impossible de le supprimer"));
    	
    	userRepository.delete(user);
    }
    
}
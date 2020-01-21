package com.mairie.biblio.biblioWebApp.proxies;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mairie.biblio.biblioWebApp.model.UserBean;


@FeignClient(name = "microservice-biblio", url = "localhost:8080")
public interface UserProxy {
	
	
    @GetMapping(value = "/user/id/{id}")
	UserBean recupererUnUser(@PathVariable("id") int id);
    
    @GetMapping(value="/user/username/{username}")
    UserBean findByUsername(@PathVariable String username);
    
    @GetMapping(value="/user/name/{name}")
    UserBean findByName(@PathVariable String name);
    

}

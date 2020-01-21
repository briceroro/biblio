package com.mairie.biblio.biblioWebApp.proxies;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mairie.biblio.biblioWebApp.model.BorrowedBookBean;


@FeignClient (name = "microservice-biblio", url = "localhost:8080")
public interface BorrowedBookProxy {
	
	@GetMapping(value="/borrowedbook/all/user/{id}")
	public List<BorrowedBookBean> findAllByuser(@PathVariable int id);
	
	@PostMapping(value="/borrowedbook/extensiondate")
	public Date extensionDateBorrowing(@RequestBody int id);

}

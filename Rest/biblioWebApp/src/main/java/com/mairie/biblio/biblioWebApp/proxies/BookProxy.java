package com.mairie.biblio.biblioWebApp.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mairie.biblio.biblioWebApp.model.BookBean;

@FeignClient (name = "microservice-biblio", url = "localhost:8080")
public interface BookProxy {

	@GetMapping(value="/book/all/bykeyswords/{mc}")
	List<BookBean> findByKeyswordsTitle(@PathVariable String mc);

	@GetMapping(value ="/book/id/{id}")
	BookBean findById(@PathVariable int id);
}
